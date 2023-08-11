package com.allianz.ecommerceproject.mapper;

import com.allianz.ecommerceproject.database.entity.TaxEntity;
import com.allianz.ecommerceproject.model.TaxDTO;
import com.allianz.ecommerceproject.model.requestDTO.TaxRequestDTO;
import com.allianz.ecommerceproject.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaxMapper implements IBaseMapper<TaxDTO, TaxEntity, TaxRequestDTO> {
    @Override
    public TaxDTO entityToDTO(TaxEntity entity) {
        TaxDTO dto = new TaxDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setRate(entity.getRate());
        return dto;


    }

    @Override
    public TaxEntity dtoToEntity(TaxDTO dto) {
        TaxEntity entity = new TaxEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setRate(dto.getRate());
        return entity;
    }

    @Override
    public List<TaxDTO> entityListToDTOList(List<TaxEntity> taxEntities) {
        List<TaxDTO> dtoList = new ArrayList<>();
        for (TaxEntity entity : taxEntities) {
            TaxDTO dto = entityToDTO(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public List<TaxEntity> dtoListTOEntityList(List<TaxDTO> TaxDTO) {
        List<TaxEntity> entityList = new ArrayList<>();
        for (TaxDTO dto : TaxDTO) {
            TaxEntity entity = dtoToEntity(dto);
            entityList.add(entity);
        }
        return entityList;
    }

    @Override
    public TaxEntity requestDTOToEntity(TaxRequestDTO dto) {
        TaxEntity entity = new TaxEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setRate(dto.getRate());
        return entity;
    }

    @Override
    public List<TaxEntity> requestDtoListTOEntityList(List<TaxRequestDTO> taxRequestDTOS) {
        return null;
    }

    @Override
    public TaxEntity requestDTOToExistEntity(TaxRequestDTO taxRequestDTO, TaxEntity entity) {
        entity.setName(taxRequestDTO.getName());
        entity.setRate(taxRequestDTO.getRate());
        entity.setCode(taxRequestDTO.getCode());
        return entity;
    }


}
