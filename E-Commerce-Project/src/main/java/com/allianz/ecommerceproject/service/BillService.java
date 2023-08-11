package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.BillEntity;
import com.allianz.ecommerceproject.database.repository.BillEntityRepository;
import com.allianz.ecommerceproject.mapper.BillMapper;
import com.allianz.ecommerceproject.model.BillDTO;
import com.allianz.ecommerceproject.model.requestDTO.BillRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BillService extends BaseService<BillDTO, BillEntity, BillRequestDTO> {

    @Autowired
    BillEntityRepository billEntityRepository;

    @Autowired
    BillMapper billMapper;

    @Override
    public BillDTO save(BillRequestDTO requestDTO) {
        BillEntity billEntity = billMapper.requestDTOToEntity(requestDTO);
        billEntityRepository.save(billEntity);
        return billMapper.entityToDTO(billEntity);
    }

    @Override
    public List<BillDTO> getAll() {
        List<BillEntity> billEntities = billEntityRepository.findAll();
        return billMapper.entityListToDTOList(billEntities);
    }

    @Override
    public BillDTO update(UUID uuid, BillRequestDTO requestDTO) {
        BillEntity billEntity = billEntityRepository.findByUuid(uuid).orElse(null);
        if (billEntity == null) {
            return null;
        }
        return billMapper.entityToDTO(billEntityRepository
                .save(billMapper.requestDTOToExistEntity(requestDTO, billEntity)));

    }

    @Override
    public Boolean delete(UUID uuid) {
       BillEntity billEntity = billEntityRepository.findByUuid(uuid).orElse(null);
       if (billEntity == null){
           return false;
       }
       billEntityRepository.delete(billEntity);
       return true;
    }

    @Override
    public BillDTO getByUuid(UUID uuid) {
        BillEntity billEntity = billEntityRepository.findByUuid(uuid).orElse(null);
        if (billEntity == null){
            return null;
        }
        return billMapper.entityToDTO(billEntity);
    }

}
