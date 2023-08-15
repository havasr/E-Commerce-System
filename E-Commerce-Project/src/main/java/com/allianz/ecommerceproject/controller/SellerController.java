package com.allianz.ecommerceproject.controller;

import com.allianz.ecommerceproject.database.entity.SellerEntity;
import com.allianz.ecommerceproject.database.repository.SellerEntityRepository;
import com.allianz.ecommerceproject.mapper.SellerMapper;
import com.allianz.ecommerceproject.model.SellerDTO;
import com.allianz.ecommerceproject.model.requestDTO.SellerRequestDTO;
import com.allianz.ecommerceproject.service.SellerService;
import com.allianz.ecommerceproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController extends BaseController<SellerDTO, SellerEntity, SellerRequestDTO, SellerMapper,
        SellerEntityRepository, SellerService> {
    @Autowired
    private SellerService sellerService;
    @Override
    protected SellerService getBaseService(){
        return sellerService;
    }
}
