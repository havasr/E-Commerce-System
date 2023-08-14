package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.BillEntity;
import com.allianz.ecommerceproject.database.repository.BillEntityRepository;
import com.allianz.ecommerceproject.mapper.BillMapper;
import com.allianz.ecommerceproject.model.BillDTO;
import com.allianz.ecommerceproject.model.requestDTO.BillRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import com.allianz.ecommerceproject.util.dbutil.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BillService extends BaseService<BillDTO, BillEntity, BillRequestDTO, BillEntityRepository, BillMapper> {

    @Autowired
    BillEntityRepository billEntityRepository;


    @Autowired
    BillMapper billMapper;


    @Override
    protected BillMapper getBaseMapper() {
        return billMapper;
    }

    @Override
    protected BillEntityRepository getBaseRepository() {
        return billEntityRepository;
    }
}
