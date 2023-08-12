package com.allianz.ecommerceproject.controller;

import com.allianz.ecommerceproject.database.entity.OrderItemEntity;
import com.allianz.ecommerceproject.model.OrderItemDTO;
import com.allianz.ecommerceproject.model.requestDTO.OrderItemRequestDTO;
import com.allianz.ecommerceproject.service.OrderItemService;
import com.allianz.ecommerceproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order-item")
public class OrderItemController extends BaseController<OrderItemDTO, OrderItemEntity, OrderItemRequestDTO, OrderItemService> {
    @Autowired
    private OrderItemService orderItemService;
    @Override
    protected OrderItemService getBaseService(){
        return orderItemService;
    }

}