package com.allianz.ecommerceproject.controller;

import com.allianz.ecommerceproject.database.entity.AddressEntity;
import com.allianz.ecommerceproject.database.repository.AddressEntityRepository;
import com.allianz.ecommerceproject.mapper.AddressMapper;
import com.allianz.ecommerceproject.model.AddressDTO;
import com.allianz.ecommerceproject.model.requestDTO.AddressRequestDTO;
import com.allianz.ecommerceproject.service.AddressService;
import com.allianz.ecommerceproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
public class AddressController extends BaseController<AddressDTO, AddressEntity, AddressRequestDTO, AddressMapper,
        AddressEntityRepository, AddressService> {

    @Autowired
    private AddressService addressService;

    @Override
    protected AddressService getBaseService() {
        return addressService;
    }

}