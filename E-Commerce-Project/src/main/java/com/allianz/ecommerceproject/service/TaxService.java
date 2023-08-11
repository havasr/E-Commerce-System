package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.TaxEntity;
import com.allianz.ecommerceproject.database.repository.TaxEntityRepository;
import com.allianz.ecommerceproject.mapper.TaxMapper;
import com.allianz.ecommerceproject.model.TaxDTO;
import com.allianz.ecommerceproject.model.requestDTO.TaxRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaxService extends BaseService<TaxDTO, TaxEntity, TaxRequestDTO> {
    @Autowired
    private TaxEntityRepository taxRepository;
    @Autowired
    private TaxMapper taxMapper;

    @Override
    public TaxDTO save(TaxRequestDTO taxRequestDTO) {
        TaxEntity tax = taxMapper.requestDTOToEntity(taxRequestDTO);
        taxRepository.save(tax);
        return taxMapper.entityToDTO(tax);
    }

    @Override
    public List<TaxDTO> getAll() {
        List<TaxEntity> taxEntities = taxRepository.findAll();
        return taxMapper.entityListToDTOList(taxEntities);
    }

    @Override
    public TaxDTO update(UUID uuid, TaxRequestDTO taxRequestDTO) {
        TaxEntity taxEntity = taxRepository.findByUuid(uuid).orElse(null);
        if (taxEntity == null) {
            return null;
        }
        return taxMapper.entityToDTO(taxRepository.save(taxMapper.requestDTOToExistEntity(taxRequestDTO, taxEntity)));
    }

    @Override
    public Boolean delete(UUID uuid) {
        TaxEntity taxEntity = taxRepository.findByUuid(uuid).orElse(null);
        if (taxEntity == null) {
            return false;
        }
        taxRepository.delete(taxEntity);
        return true;
    }

    @Override
    public TaxDTO getByUuid(UUID uuid) {
        TaxEntity taxEntity = taxRepository.findByUuid(uuid).orElse(null);
        if (taxEntity == null) {
            return null;
        }
        return taxMapper.entityToDTO(taxEntity);
    }

}