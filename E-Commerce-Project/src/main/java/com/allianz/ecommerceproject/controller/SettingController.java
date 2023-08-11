package com.allianz.ecommerceproject.controller;

import com.allianz.ecommerceproject.database.entity.SettingEntity;
import com.allianz.ecommerceproject.model.SettingDTO;
import com.allianz.ecommerceproject.model.requestDTO.SettingRequestDTO;
import com.allianz.ecommerceproject.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("setting")
public class SettingController {

    @Autowired
    SettingService settingService;

    @GetMapping("")
    public ResponseEntity<List<SettingDTO>> getAll() {
        return new ResponseEntity<>(settingService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<SettingDTO> getByUuid(@PathVariable UUID uuid) {
        SettingDTO dto = settingService.getSettingByUuid(uuid);
        if (dto == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<SettingDTO> save(@RequestBody SettingRequestDTO requestDTO) {
        return new ResponseEntity<>(settingService.save(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public  ResponseEntity<SettingDTO> updateSetting(@PathVariable UUID uuid, @RequestBody SettingRequestDTO requestDTO){
        SettingDTO dto = settingService.update(uuid, requestDTO);
        if (dto == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(settingService.update(uuid, requestDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Boolean> deleteSetting(@PathVariable UUID uuid){
        boolean isDeleted = settingService.delete(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(isDeleted, HttpStatus.OK);
        }
        return new ResponseEntity<>(isDeleted, HttpStatus.NOT_FOUND);
    }

}
