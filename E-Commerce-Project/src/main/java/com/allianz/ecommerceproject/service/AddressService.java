package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.AddressEntity;
import com.allianz.ecommerceproject.database.repository.AddressEntityRepository;
import com.allianz.ecommerceproject.mapper.AddressMapper;
import com.allianz.ecommerceproject.model.AddressDTO;
import com.allianz.ecommerceproject.model.requestDTO.AddressRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService<AddressDTO, AddressEntity, AddressRequestDTO, AddressEntityRepository, AddressMapper> {

    @Autowired
    private AddressMapper addressMapper;
    @Override
    protected AddressMapper getBaseMapper() { return addressMapper;}

    @Autowired
    private AddressEntityRepository addressEntityRepository;
    @Override
    protected AddressEntityRepository getBaseRepository() { return addressEntityRepository;}

}
