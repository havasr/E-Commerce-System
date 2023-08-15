package com.allianz.ecommerceproject.controller;

import com.allianz.ecommerceproject.database.entity.CustomerEntity;
import com.allianz.ecommerceproject.database.repository.CustomerEntityRepository;
import com.allianz.ecommerceproject.mapper.CustomerMapper;
import com.allianz.ecommerceproject.model.CustomerDTO;
import com.allianz.ecommerceproject.model.requestDTO.CustomerRequestDTO;
import com.allianz.ecommerceproject.service.CustomerService;
import com.allianz.ecommerceproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController extends BaseController<CustomerDTO, CustomerEntity, CustomerRequestDTO, CustomerMapper,
        CustomerEntityRepository, CustomerService> {
    @Autowired
    private CustomerService customerService;
    @Override
    protected CustomerService getBaseService(){
        return customerService;
    }

}