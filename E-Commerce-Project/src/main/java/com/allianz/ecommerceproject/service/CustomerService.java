package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.CustomerEntity;
import com.allianz.ecommerceproject.database.repository.CustomerEntityRepository;
import com.allianz.ecommerceproject.mapper.CustomerMapper;
import com.allianz.ecommerceproject.model.CustomerDTO;
import com.allianz.ecommerceproject.model.requestDTO.CustomerRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<CustomerDTO, CustomerEntity, CustomerRequestDTO,
        CustomerEntityRepository, CustomerMapper> {

    @Autowired
    CustomerEntityRepository customerEntityRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    protected CustomerMapper getBaseMapper() {
        return customerMapper;
    }

    @Override
    protected CustomerEntityRepository getBaseRepository() {
        return customerEntityRepository;
    }
}
