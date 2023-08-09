package com.allianz.ecommerceproject.controller;

import com.allianz.ecommerceproject.model.SettingDTO;
import com.allianz.ecommerceproject.model.requestDTO.SettingRequestDTO;
import com.allianz.ecommerceproject.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("setting")
public class SettingController {

    @Autowired
    SettingService settingService;
    @PostMapping("")
    public ResponseEntity<SettingDTO> save(@RequestBody SettingRequestDTO requestDTO) {
        return new ResponseEntity<>(settingService.save(requestDTO), HttpStatus.CREATED);
    }

}
