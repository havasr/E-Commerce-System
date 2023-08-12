package com.allianz.ecommerceproject.controller;

import com.allianz.ecommerceproject.database.entity.CategoryEntity;
import com.allianz.ecommerceproject.model.CategoryDTO;
import com.allianz.ecommerceproject.model.requestDTO.CategoryRequestDTO;
import com.allianz.ecommerceproject.service.CategoryService;
import com.allianz.ecommerceproject.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController extends BaseController<CategoryDTO, CategoryEntity, CategoryRequestDTO, CategoryService> {
    @Autowired
    private CategoryService categoryService;
    @Override
    protected CategoryService getBaseService(){
        return categoryService;
    }

}