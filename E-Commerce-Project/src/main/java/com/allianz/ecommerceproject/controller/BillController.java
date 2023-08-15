package com.allianz.ecommerceproject.controller;

import com.allianz.ecommerceproject.database.entity.BillEntity;
import com.allianz.ecommerceproject.database.repository.BillEntityRepository;
import com.allianz.ecommerceproject.mapper.BillMapper;
import com.allianz.ecommerceproject.model.BillDTO;
import com.allianz.ecommerceproject.model.requestDTO.BillRequestDTO;
import com.allianz.ecommerceproject.service.BillService;
import com.allianz.ecommerceproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bill")
public class BillController extends BaseController<BillDTO, BillEntity, BillRequestDTO, BillMapper,
        BillEntityRepository, BillService> {

    @Autowired
    private BillService billService;
    @Override
    protected BillService getBaseService(){
        return billService;
    }

}