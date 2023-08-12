package com.allianz.ecommerceproject.controller;

import com.allianz.ecommerceproject.database.entity.PersonEntity;
import com.allianz.ecommerceproject.model.PersonDTO;
import com.allianz.ecommerceproject.model.requestDTO.PersonRequestDTO;
import com.allianz.ecommerceproject.service.PersonService;
import com.allianz.ecommerceproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
public class PersonController extends BaseController<PersonDTO, PersonEntity, PersonRequestDTO, PersonService> {
    @Autowired
    private PersonService personService;
    @Override
    protected PersonService getBaseService(){
        return personService;
    }

}