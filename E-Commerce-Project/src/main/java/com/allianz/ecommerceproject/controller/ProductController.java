package com.allianz.ecommerceproject.controller;

import com.allianz.ecommerceproject.database.entity.ProductEntity;
import com.allianz.ecommerceproject.database.repository.ProductEntityRepository;
import com.allianz.ecommerceproject.mapper.ProductMapper;
import com.allianz.ecommerceproject.model.ProductDTO;
import com.allianz.ecommerceproject.model.requestDTO.ProductRequestDTO;
import com.allianz.ecommerceproject.service.ProductService;
import com.allianz.ecommerceproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController extends BaseController<ProductDTO, ProductEntity, ProductRequestDTO, ProductMapper,
        ProductEntityRepository, ProductService> {
    @Autowired
    private ProductService productService;
    @Override
    protected ProductService getBaseService(){
        return productService;
    }

}