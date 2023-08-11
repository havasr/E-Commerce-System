package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.SettingEntity;
import com.allianz.ecommerceproject.database.repository.SettingEntityRepository;
import com.allianz.ecommerceproject.mapper.SettingMapper;
import com.allianz.ecommerceproject.model.PersonDTO;
import com.allianz.ecommerceproject.model.SettingDTO;
import com.allianz.ecommerceproject.model.requestDTO.SettingRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SettingService {

    @Autowired
    SettingEntityRepository settingEntityRepository;

    @Autowired
    SettingMapper settingMapper;

    public SettingDTO save(SettingRequestDTO requestDTO) {

        SettingEntity settingEntity = settingMapper.requestDTOToEntity(requestDTO);
        settingEntityRepository.save(settingEntity);
        return settingMapper.entityToDTO(settingEntity);
    }

    public List<SettingDTO> getAll(){
        List<SettingEntity> settingEntities = settingEntityRepository.findAll();
        return settingMapper.entityListToDTOList(settingEntities);
    }

    public SettingDTO update(UUID uuid, SettingRequestDTO requestDTO) {
        SettingEntity settingEntity = settingEntityRepository.findByUuid(uuid).orElse(null);
        if (settingEntity == null) {
            return null;
        }
        //settingEntityRepository.save(settingMapper.requestDtoToExistEntity(requestDTO, settingEntity));
        return settingMapper.entityToDTO(settingEntityRepository.save(settingMapper.requestDTOToExistEntity(requestDTO, settingEntity)));
    }

    @Transactional
    public boolean delete(UUID uuid) {
        Optional<SettingEntity> settingEntity = settingEntityRepository.findByUuid(uuid);
        if (settingEntity.isPresent()) {
            settingEntityRepository.delete(settingEntity.get());
            return true;
        }
        return false;
    }

    public SettingDTO getSettingByUuid(UUID uuid) {
        Optional<SettingEntity> settingEntity = settingEntityRepository.findByUuid(uuid);
        if (settingEntity.isPresent()) {
            return settingMapper.entityToDTO(settingEntity.get());
        }
        return null;
    }
}
