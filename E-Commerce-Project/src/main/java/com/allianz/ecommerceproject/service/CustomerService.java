package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.CustomerEntity;
import com.allianz.ecommerceproject.database.repository.CustomerEntityRepository;
import com.allianz.ecommerceproject.mapper.CustomerMapper;
import com.allianz.ecommerceproject.model.CustomerDTO;
import com.allianz.ecommerceproject.model.requestDTO.CustomerRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService extends BaseService<CustomerDTO, CustomerEntity, CustomerRequestDTO> {

    @Autowired
    CustomerEntityRepository customerEntityRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public CustomerDTO save(CustomerRequestDTO requestDTO){
       CustomerEntity customerEntity = customerMapper.requestDTOToEntity(requestDTO);
       customerEntityRepository.save(customerEntity);
       return customerMapper.entityToDTO(customerEntity);
    }

    @Override
    public List<CustomerDTO> getAll(){
        List<CustomerEntity> customerEntities = customerEntityRepository.findAll();
        return customerMapper.entityListToDTOList(customerEntities);
    }

    @Override
    public CustomerDTO update(UUID uuid, CustomerRequestDTO requestDTO){
        CustomerEntity customerEntity = customerEntityRepository.findByUuid(uuid).orElse(null);
        if (customerEntity == null){
            return null;
        }
        return customerMapper.entityToDTO(customerEntityRepository
                .save(customerMapper.requestDTOToExistEntity(requestDTO, customerEntity)));
    }

    @Override
    public Boolean delete(UUID uuid){
        CustomerEntity customerEntity = customerEntityRepository.findByUuid(uuid).orElse(null);
        if (customerEntity == null){
            return false;
        }
        customerEntityRepository.delete(customerEntity);
        return true;
    }

    @Override
    public CustomerDTO getByUuid(UUID uuid){
        CustomerEntity customerEntity = customerEntityRepository.findByUuid(uuid).orElse(null);
        if (customerEntity == null){
            return null;
        }
        return customerMapper.entityToDTO(customerEntity);
    }
}
