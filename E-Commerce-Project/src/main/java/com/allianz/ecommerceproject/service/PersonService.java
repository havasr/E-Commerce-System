package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.PersonEntity;
import com.allianz.ecommerceproject.database.repository.PersonEntityRepository;
import com.allianz.ecommerceproject.mapper.PersonMapper;
import com.allianz.ecommerceproject.model.PersonDTO;
import com.allianz.ecommerceproject.model.requestDTO.PersonRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import com.allianz.ecommerceproject.util.IBaseMapper;
import com.allianz.ecommerceproject.util.dbutil.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService extends BaseService<PersonDTO, PersonEntity, PersonRequestDTO,
        PersonEntityRepository, PersonMapper> {

    @Autowired
    PersonEntityRepository personEntityRepository;
    @Autowired
    PersonMapper personMapper;

    @Override
    protected PersonMapper getBaseMapper() {
        return personMapper;
    }

    @Override
    protected PersonEntityRepository getBaseRepository() {
        return personEntityRepository;
    }
}
