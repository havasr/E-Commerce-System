package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.ProductEntity;
import com.allianz.ecommerceproject.database.repository.ProductEntityRepository;
import com.allianz.ecommerceproject.mapper.ProductMapper;
import com.allianz.ecommerceproject.model.ProductDTO;
import com.allianz.ecommerceproject.model.requestDTO.ProductRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import com.allianz.ecommerceproject.util.IBaseMapper;
import com.allianz.ecommerceproject.util.dbutil.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService extends BaseService<ProductDTO, ProductEntity, ProductRequestDTO,
        ProductEntityRepository, ProductMapper> {

    @Autowired
    ProductEntityRepository productEntityRepository;
    @Autowired
    ProductMapper productMapper;

    @Override
    protected ProductMapper getBaseMapper() {
        return productMapper;
    }

    @Override
    protected ProductEntityRepository getBaseRepository() {
        return productEntityRepository;
    }
}
