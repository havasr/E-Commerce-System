package com.allianz.ecommerceproject.controller;

import com.allianz.ecommerceproject.database.entity.TaxEntity;
import com.allianz.ecommerceproject.database.repository.TaxEntityRepository;
import com.allianz.ecommerceproject.mapper.TaxMapper;
import com.allianz.ecommerceproject.model.TaxDTO;
import com.allianz.ecommerceproject.model.requestDTO.TaxRequestDTO;
import com.allianz.ecommerceproject.service.TaxService;
import com.allianz.ecommerceproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tax")
public class TaxController extends BaseController<TaxDTO, TaxEntity, TaxRequestDTO, TaxMapper, TaxEntityRepository,
        TaxService> {
    @Autowired
    private TaxService taxService;

    @Override
    protected TaxService getBaseService() {
        return taxService;
    }

}
