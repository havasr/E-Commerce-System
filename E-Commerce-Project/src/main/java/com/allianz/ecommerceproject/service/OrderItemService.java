package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.OrderItemEntity;
import com.allianz.ecommerceproject.database.repository.OrderItemEntityRepository;
import com.allianz.ecommerceproject.mapper.OrderItemMapper;
import com.allianz.ecommerceproject.model.OrderItemDTO;
import com.allianz.ecommerceproject.model.requestDTO.OrderItemRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderItemService extends BaseService<OrderItemDTO, OrderItemEntity, OrderItemRequestDTO> {

    @Autowired
    OrderItemEntityRepository orderItemEntityRepository;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    public OrderItemDTO save(OrderItemRequestDTO requestDTO){
        OrderItemEntity orderItemEntity = orderItemMapper.requestDTOToEntity(requestDTO);
        orderItemEntityRepository.save(orderItemEntity);
       return orderItemMapper.entityToDTO(orderItemEntity);
    }

    @Override
    public List<OrderItemDTO> getAll(){
        List<OrderItemEntity> orderItemEntities = orderItemEntityRepository.findAll();
        return orderItemMapper.entityListToDTOList(orderItemEntities);
    }

    @Override
    public OrderItemDTO update(UUID uuid, OrderItemRequestDTO requestDTO){
        OrderItemEntity orderItemEntity = orderItemEntityRepository.findByUuid(uuid).orElse(null);
        if (orderItemEntity == null){
            return null;
        }
        return orderItemMapper.entityToDTO(orderItemEntityRepository
                .save(orderItemMapper.requestDTOToExistEntity(requestDTO, orderItemEntity)));
    }

    @Override
    public Boolean delete(UUID uuid){
        OrderItemEntity orderItemEntity = orderItemEntityRepository.findByUuid(uuid).orElse(null);
        if (orderItemEntity == null){
            return false;
        }
        orderItemEntityRepository.delete(orderItemEntity);
        return true;
    }

    @Override
    public OrderItemDTO getByUuid(UUID uuid){
        OrderItemEntity orderItemEntity = orderItemEntityRepository.findByUuid(uuid).orElse(null);
        if (orderItemEntity == null){
            return null;
        }
        return orderItemMapper.entityToDTO(orderItemEntity);
    }
}
