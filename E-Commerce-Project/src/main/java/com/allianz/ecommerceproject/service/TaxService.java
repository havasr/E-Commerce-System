package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.TaxEntity;
import com.allianz.ecommerceproject.database.repository.TaxEntityRepository;
import com.allianz.ecommerceproject.mapper.TaxMapper;
import com.allianz.ecommerceproject.model.TaxDTO;
import com.allianz.ecommerceproject.model.requestDTO.TaxRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import com.allianz.ecommerceproject.util.IBaseMapper;
import com.allianz.ecommerceproject.util.dbutil.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaxService extends BaseService<TaxDTO, TaxEntity, TaxRequestDTO, TaxEntityRepository
        , TaxMapper> {
    @Autowired
    private TaxEntityRepository taxRepository;
    @Autowired
    private TaxMapper taxMapper;

    @Override
    protected TaxMapper getBaseMapper() {
        return taxMapper;
    }

    @Override
    protected TaxEntityRepository getBaseRepository() {
        return taxRepository;
    }


    //Override edebiliyoruz
    @Override
    public TaxDTO update(UUID uuid, TaxRequestDTO requestDTO) {
        return null;
    }
}