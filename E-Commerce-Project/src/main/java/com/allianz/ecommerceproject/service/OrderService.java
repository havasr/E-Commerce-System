package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.OrderEntity;
import com.allianz.ecommerceproject.database.repository.OrderEntityRepository;
import com.allianz.ecommerceproject.mapper.OrderMapper;
import com.allianz.ecommerceproject.model.OrderDTO;
import com.allianz.ecommerceproject.model.requestDTO.OrderRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService extends BaseService<OrderDTO, OrderEntity, OrderRequestDTO> {

    @Autowired
    OrderEntityRepository orderEntityRepository;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public OrderDTO save(OrderRequestDTO requestDTO){
        OrderEntity orderEntity = orderMapper.requestDTOToEntity(requestDTO);
        orderEntityRepository.save(orderEntity);
       return orderMapper.entityToDTO(orderEntity);
    }

    @Override
    public List<OrderDTO> getAll(){
        List<OrderEntity> orderEntities = orderEntityRepository.findAll();
        return orderMapper.entityListToDTOList(orderEntities);
    }

    @Override
    public OrderDTO update(UUID uuid, OrderRequestDTO requestDTO){
        OrderEntity orderEntity = orderEntityRepository.findByUuid(uuid).orElse(null);
        if (orderEntity == null){
            return null;
        }
        return orderMapper.entityToDTO(orderEntityRepository
                .save(orderMapper.requestDTOToExistEntity(requestDTO, orderEntity)));
    }

    @Override
    public Boolean delete(UUID uuid){
        OrderEntity orderEntity = orderEntityRepository.findByUuid(uuid).orElse(null);
        if (orderEntity == null){
            return false;
        }
        orderEntityRepository.delete(orderEntity);
        return true;
    }

    @Override
    public OrderDTO getByUuid(UUID uuid){
        OrderEntity orderEntity = orderEntityRepository.findByUuid(uuid).orElse(null);
        if (orderEntity == null){
            return null;
        }
        return orderMapper.entityToDTO(orderEntity);
    }
}
