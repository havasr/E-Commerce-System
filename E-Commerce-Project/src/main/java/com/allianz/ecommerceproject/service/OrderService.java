package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.OrderEntity;
import com.allianz.ecommerceproject.database.repository.OrderEntityRepository;
import com.allianz.ecommerceproject.mapper.OrderMapper;
import com.allianz.ecommerceproject.model.OrderDTO;
import com.allianz.ecommerceproject.model.requestDTO.OrderRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import com.allianz.ecommerceproject.util.IBaseMapper;
import com.allianz.ecommerceproject.util.dbutil.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService extends BaseService<OrderDTO, OrderEntity, OrderRequestDTO, OrderEntityRepository,
        OrderMapper> {

    @Autowired
    OrderEntityRepository orderEntityRepository;

    @Autowired
    OrderMapper orderMapper;

    @Override
    protected OrderMapper getBaseMapper() {
        return null;
    }

    @Override
    protected OrderEntityRepository getBaseRepository() {
        return null;
    }
}
