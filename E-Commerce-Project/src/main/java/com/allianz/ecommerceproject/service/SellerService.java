package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.SellerEntity;
import com.allianz.ecommerceproject.database.repository.SellerEntityRepository;
import com.allianz.ecommerceproject.mapper.SellerMapper;
import com.allianz.ecommerceproject.model.SellerDTO;
import com.allianz.ecommerceproject.model.requestDTO.SellerRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService extends BaseService<SellerDTO, SellerEntity, SellerRequestDTO,
        SellerEntityRepository, SellerMapper> {
    @Autowired
    SellerEntityRepository sellerRepository;
    @Autowired
    SellerMapper sellerMapper;

    @Override
    protected SellerMapper getBaseMapper() {
        return sellerMapper;
    }

    @Override
    protected SellerEntityRepository getBaseRepository() {
        return sellerRepository;
    }
}
