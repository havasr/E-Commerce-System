package com.allianz.ecommerceproject.mapper;

import com.allianz.ecommerceproject.database.entity.OrderEntity;
import com.allianz.ecommerceproject.model.OrderDTO;
import com.allianz.ecommerceproject.model.requestDTO.OrderRequestDTO;
import com.allianz.ecommerceproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper implements IBaseMapper<OrderDTO, OrderEntity, OrderRequestDTO> {

    @Autowired
    @Lazy
    CustomerMapper customerMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    public OrderDTO entityToDTO(OrderEntity entity) {

        OrderDTO dto = new OrderDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());

        dto.setCustomer(customerMapper.entityToDTO(entity.getCustomer()));
        dto.setOrderStatus(entity.getOrderStatus());
        dto.setOrderItemList(orderItemMapper.entityListToDTOList(entity.getOrderItemList()));
        dto.setTotalSellPrice(entity.getTotalSellPrice());

        return dto;
    }

    @Override
    public OrderEntity dtoToEntity(OrderDTO dto) {
        OrderEntity entity = new OrderEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCustomer(customerMapper.dtoToEntity(dto.getCustomer()));
        entity.setOrderStatus(dto.getOrderStatus());
        entity.setOrderItemList(orderItemMapper.dtoListTOEntityList(dto.getOrderItemList()));
        entity.setTotalSellPrice(dto.getTotalSellPrice());
        return entity;
    }

    @Override
    public List<OrderDTO> entityListToDTOList(List<OrderEntity> orderEntities) {
        return null;
    }

    @Override
    public List<OrderEntity> dtoListTOEntityList(List<OrderDTO> orderDTOS) {
        return null;
    }

    @Override
    public OrderEntity requestDTOToEntity(OrderRequestDTO dto) {
        OrderEntity entity = new OrderEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setOrderItemList(orderItemMapper.requestDtoListTOEntityList(dto.getOrderItemList()));
        return entity;
    }

    @Override
    public List<OrderEntity> requestDtoListTOEntityList(List<OrderRequestDTO> orderRequestDTOS) {
        return null;
    }

    @Override
    public OrderEntity requestDTOToExistEntity(OrderRequestDTO orderRequestDTO, OrderEntity entity) {
        return null;
    }
}
