package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.SettingEntity;
import com.allianz.ecommerceproject.database.repository.SettingEntityRepository;
import com.allianz.ecommerceproject.mapper.SettingMapper;
import com.allianz.ecommerceproject.model.SettingDTO;
import com.allianz.ecommerceproject.model.requestDTO.SettingRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
