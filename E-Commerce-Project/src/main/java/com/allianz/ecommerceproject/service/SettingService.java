package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.SettingEntity;
import com.allianz.ecommerceproject.database.repository.SettingEntityRepository;
import com.allianz.ecommerceproject.mapper.SettingMapper;
import com.allianz.ecommerceproject.model.SettingDTO;
import com.allianz.ecommerceproject.model.requestDTO.SettingRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class SettingService extends BaseService<SettingDTO,SettingEntity,SettingRequestDTO> {

    @Autowired
    SettingEntityRepository settingEntityRepository;

    @Autowired
    SettingMapper settingMapper;

    @Override
    public SettingDTO save(SettingRequestDTO requestDTO) {
        SettingEntity settingEntity = settingMapper.requestDTOToEntity(requestDTO);
        settingEntityRepository.save(settingEntity);
        return settingMapper.entityToDTO(settingEntity);
    }

    @Override
    public List<SettingDTO> getAll(){
        List<SettingEntity> settingEntities = settingEntityRepository.findAll();
        return settingMapper.entityListToDTOList(settingEntities);
    }

    @Override
    public SettingDTO update(UUID uuid, SettingRequestDTO requestDTO) {
        SettingEntity settingEntity = settingEntityRepository.findByUuid(uuid).orElse(null);
        if (settingEntity == null) {
            return null;
        }
        return settingMapper.entityToDTO(settingEntityRepository
                .save(settingMapper.requestDTOToExistEntity(requestDTO, settingEntity)));
    }

    @Override
    public Boolean delete(UUID uuid) {
        Optional<SettingEntity> settingEntity = settingEntityRepository.findByUuid(uuid);
        if (settingEntity.isPresent()) {
            settingEntityRepository.delete(settingEntity.get());
            return true;
        }
        return false;
    }

    @Override
    public SettingDTO getByUuid(UUID uuid) {
        Optional<SettingEntity> settingEntity = settingEntityRepository.findByUuid(uuid);
        if (settingEntity.isPresent()) {
            return settingMapper.entityToDTO(settingEntity.get());
        }
        return null;
    }
}
