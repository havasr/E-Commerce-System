package com.allianz.ecommerceproject.mapper;

import com.allianz.ecommerceproject.database.entity.OrderItemEntity;
import com.allianz.ecommerceproject.model.OrderItemDTO;
import com.allianz.ecommerceproject.model.requestDTO.OrderItemRequestDTO;
import com.allianz.ecommerceproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderItemMapper implements IBaseMapper<OrderItemDTO, OrderItemEntity, OrderItemRequestDTO> {

    @Autowired
    ProductMapper productMapper;

    @Override
    public OrderItemDTO entityToDTO(OrderItemEntity entity) {

        OrderItemDTO dto = new OrderItemDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setProduct(productMapper.entityToDTO(entity.getProduct()));
        dto.setQuantity(entity.getQuantity());
        dto.setSellPrice(entity.getSellPrice());


        return dto;
    }

    @Override
    public OrderItemEntity dtoToEntity(OrderItemDTO dto) {
        OrderItemEntity entity = new OrderItemEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setProduct(productMapper.dtoToEntity(dto.getProduct()));
        entity.setQuantity(dto.getQuantity());
        entity.setSellPrice(dto.getSellPrice());

        return entity;
    }

    @Override
    public List<OrderItemDTO> entityListToDTOList(List<OrderItemEntity> orderItemEntities) {
        List<OrderItemDTO> dtoList = new ArrayList<>();
        for (OrderItemEntity entity : orderItemEntities) {
            OrderItemDTO dto = entityToDTO(entity);
            dtoList.add(dto);

        }
        return dtoList;
    }

    @Override
    public List<OrderItemEntity> dtoListTOEntityList(List<OrderItemDTO> orderItemDTOS) {
        List<OrderItemEntity> entityList = new ArrayList<>();
        for (OrderItemDTO dto : orderItemDTOS) {
            OrderItemEntity entity = dtoToEntity(dto);
            entityList.add(entity);

        }
        return entityList;
    }

    @Override
    public OrderItemEntity requestDTOToEntity(OrderItemRequestDTO dto) {
        OrderItemEntity entity = new OrderItemEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setProduct(productMapper.requestDTOToEntity(dto.getProduct()));
        entity.setQuantity(dto.getQuantity());
        entity.setSellPrice(dto.getSellPrice());
        return entity;
    }

    @Override
    public List<OrderItemEntity> requestDtoListTOEntityList(List<OrderItemRequestDTO> orderItemRequestDTOS) {

        List<OrderItemEntity> entityList = new ArrayList<>();

        for (OrderItemRequestDTO dto : orderItemRequestDTOS) {
            OrderItemEntity entity = requestDTOToEntity(dto);
            entityList.add(entity);

        }
        return entityList;
    }
}
