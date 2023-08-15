package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.CategoryEntity;
import com.allianz.ecommerceproject.database.repository.CategoryEntityRepository;
import com.allianz.ecommerceproject.mapper.CategoryMapper;
import com.allianz.ecommerceproject.model.CategoryDTO;
import com.allianz.ecommerceproject.model.requestDTO.CategoryRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseService<CategoryDTO, CategoryEntity, CategoryRequestDTO,
        CategoryEntityRepository, CategoryMapper> {

    @Autowired
    CategoryEntityRepository categoryEntityRepository;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    protected CategoryMapper getBaseMapper() {
        return categoryMapper;
    }

    @Override
    protected CategoryEntityRepository getBaseRepository() {
        return categoryEntityRepository;
    }
}
