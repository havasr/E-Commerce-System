package com.allianz.ecommerceproject.controller;

import com.allianz.ecommerceproject.database.entity.OrderEntity;
import com.allianz.ecommerceproject.model.OrderDTO;
import com.allianz.ecommerceproject.model.requestDTO.OrderRequestDTO;
import com.allianz.ecommerceproject.service.OrderService;
import com.allianz.ecommerceproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController extends BaseController<OrderDTO, OrderEntity, OrderRequestDTO, OrderService> {
    @Autowired
    private OrderService orderService;
    @Override
    protected OrderService getBaseService(){
        return orderService;
    }

}