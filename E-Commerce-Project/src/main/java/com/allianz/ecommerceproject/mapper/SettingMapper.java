package com.allianz.ecommerceproject.mapper;

import com.allianz.ecommerceproject.database.entity.SettingEntity;
import com.allianz.ecommerceproject.model.SettingDTO;
import com.allianz.ecommerceproject.model.requestDTO.SettingRequestDTO;
import com.allianz.ecommerceproject.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SettingMapper implements IBaseMapper<SettingDTO, SettingEntity, SettingRequestDTO> {
    @Override
    public SettingDTO entityToDTO(SettingEntity entity) {
        SettingDTO dto = new SettingDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setKey(entity.getKey());
        dto.setValue(entity.getValue());

        return dto;
    }

    @Override
    public SettingEntity dtoToEntity(SettingDTO dto) {
        SettingEntity entity = new SettingEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setKey(dto.getKey());
        entity.setValue(dto.getValue());

        return entity;
    }

    @Override
    public List<SettingDTO> entityListToDTOList(List<SettingEntity> settingEntities) {
        List<SettingDTO> dtoList = new ArrayList<>();
        for (SettingEntity entity : settingEntities) {
            SettingDTO dto = entityToDTO(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<SettingEntity> dtoListTOEntityList(List<SettingDTO> settingDTOS) {
        List<SettingEntity> dtoList = new ArrayList<>();
        for (SettingDTO dto : settingDTOS) {
            SettingEntity entity = dtoToEntity(dto);
            dtoList.add(entity);
        }
        return dtoList;
    }

    @Override
    public SettingEntity requestDTOToEntity(SettingRequestDTO dto) {
        SettingEntity entity = new SettingEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setKey(dto.getKey());
        entity.setValue(dto.getValue());
        return entity;
    }

    @Override
    public List<SettingEntity> requestDtoListTOEntityList(List<SettingRequestDTO> settingRequestDTOS) {
        return null;
    }

    @Override
    public SettingEntity requestDTOToExistEntity(SettingRequestDTO settingRequestDTO, SettingEntity entity) {
        entity.setKey(settingRequestDTO.getKey());
        entity.setValue(settingRequestDTO.getValue());
        return entity;
    }

}
