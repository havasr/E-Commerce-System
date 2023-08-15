package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.OrderItemEntity;
import com.allianz.ecommerceproject.database.repository.OrderItemEntityRepository;
import com.allianz.ecommerceproject.mapper.OrderItemMapper;
import com.allianz.ecommerceproject.model.OrderItemDTO;
import com.allianz.ecommerceproject.model.requestDTO.OrderItemRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderItemService extends BaseService<OrderItemDTO, OrderItemEntity, OrderItemRequestDTO,
        OrderItemEntityRepository, OrderItemMapper> {

    @Autowired
    OrderItemEntityRepository orderItemEntityRepository;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    protected OrderItemMapper getBaseMapper() {
        return orderItemMapper;
    }

    @Override
    protected OrderItemEntityRepository getBaseRepository() {
        return orderItemEntityRepository;
    }
}
