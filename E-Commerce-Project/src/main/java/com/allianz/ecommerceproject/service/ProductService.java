package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.ProductEntity;
import com.allianz.ecommerceproject.database.repository.ProductEntityRepository;
import com.allianz.ecommerceproject.mapper.ProductMapper;
import com.allianz.ecommerceproject.model.ProductDTO;
import com.allianz.ecommerceproject.model.requestDTO.ProductRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService extends BaseService<ProductDTO, ProductEntity, ProductRequestDTO> {

    @Autowired
    ProductEntityRepository productEntityRepository;
    @Autowired
    ProductMapper productMapper;

    @Override
    public ProductDTO save(ProductRequestDTO requestDTO) {
        ProductEntity productEntity = productMapper.requestDTOToEntity(requestDTO);
        productEntityRepository.save(productEntity);
        return productMapper.entityToDTO(productEntity);
    }

    @Override
    public List<ProductDTO> getAll() {
        List<ProductEntity> productEntities = productEntityRepository.findAll();
        return productMapper.entityListToDTOList(productEntities);
    }

    @Override
    public ProductDTO update(UUID uuid, ProductRequestDTO requestDTO) {
        ProductEntity productEntity = productEntityRepository.findByUuid(uuid).orElse(null);
        if (productEntity == null){
            return null;
        }
        return productMapper.entityToDTO(productEntityRepository
                .save(productMapper.requestDTOToExistEntity(requestDTO, productEntity)));
    }

    @Override
    public Boolean delete(UUID uuid) {
        ProductEntity productEntity = productEntityRepository.findByUuid(uuid).orElse(null);
        if (productEntity == null){
            return false;
        }
        productEntityRepository.delete(productEntity);
        return true;
    }

    @Override
    public ProductDTO getByUuid(UUID uuid) {
        ProductEntity productEntity = productEntityRepository.findByUuid(uuid).orElse(null);
        if (productEntity == null){
            return null;
        }
        return productMapper.entityToDTO(productEntity);
    }
}
