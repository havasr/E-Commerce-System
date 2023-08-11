package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.SellerEntity;
import com.allianz.ecommerceproject.database.repository.SellerEntityRepository;
import com.allianz.ecommerceproject.mapper.SellerMapper;
import com.allianz.ecommerceproject.model.SellerDTO;
import com.allianz.ecommerceproject.model.requestDTO.SellerRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SellerService extends BaseService<SellerDTO, SellerEntity, SellerRequestDTO> {
    @Autowired
    SellerEntityRepository sellerRepository;
    @Autowired
    SellerMapper sellerMapper;

    @Override
    public SellerDTO save(SellerRequestDTO sellerRequestDTO) {
        SellerEntity seller = sellerMapper.requestDTOToEntity(sellerRequestDTO);
        sellerRepository.save(seller);
        return sellerMapper.entityToDTO(seller);
    }

    @Override
    public List<SellerDTO> getAll() {
        List<SellerEntity> sellerEntities = sellerRepository.findAll();
        return sellerMapper.entityListToDTOList(sellerEntities);
    }

    @Override
    public SellerDTO update(UUID uuid, SellerRequestDTO sellerRequestDTO) {
        SellerEntity sellerEntity = sellerRepository.findByUuid(uuid).orElse(null);
        if (sellerEntity == null) {
            return null;
        }
        return sellerMapper.entityToDTO(sellerRepository.save(sellerMapper.requestDTOToExistEntity(sellerRequestDTO, sellerEntity)));
    }

    @Override
    public Boolean delete(UUID uuid) {
        SellerEntity sellerEntity = sellerRepository.findByUuid(uuid).orElse(null);
        if (sellerEntity == null) {
            return false;
        }
        sellerRepository.delete(sellerEntity);
        return true;
    }

    @Override
    public SellerDTO getSettingByUuid(UUID uuid) {
        SellerEntity sellerEntity = sellerRepository.findByUuid(uuid).orElse(null);
        if (sellerEntity == null) {
            return null;
        }
        return sellerMapper.entityToDTO(sellerEntity);
    }
}