package com.allianz.ecommerceproject.mapper;

import com.allianz.ecommerceproject.database.entity.AddressEntity;
import com.allianz.ecommerceproject.database.entity.CategoryEntity;
import com.allianz.ecommerceproject.database.entity.ProductEntity;
import com.allianz.ecommerceproject.model.AddressDTO;
import com.allianz.ecommerceproject.model.CategoryDTO;
import com.allianz.ecommerceproject.model.PageDTO;
import com.allianz.ecommerceproject.model.ProductDTO;
import com.allianz.ecommerceproject.model.requestDTO.CategoryRequestDTO;
import com.allianz.ecommerceproject.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CategoryMapper implements IBaseMapper<CategoryDTO, CategoryEntity, CategoryRequestDTO> {

    @Autowired
    ProductMapper productMapper;

    @Override
    public CategoryDTO entityToDTO(CategoryEntity entity) {

        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setName(entity.getName());
        Set<ProductDTO> productDTOS = new HashSet<>(new ArrayList<>(productMapper.entityListToDTOList(new ArrayList<>(entity.getProductList()))));
        dto.setProductList(productDTOS);
        return dto;
    }

    @Override
    public CategoryEntity dtoToEntity(CategoryDTO dto) {

        CategoryEntity entity = new CategoryEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        Set<ProductEntity> productEntities = new HashSet<>(
                productMapper.dtoListTOEntityList(new ArrayList<>(dto.getProductList())));
        entity.setProductList(productEntities);
        return entity;
    }

    @Override
    public List<CategoryDTO> entityListToDTOList(List<CategoryEntity> categoryEntities) {

        List<CategoryDTO> dtoList = new ArrayList<>();

        for (CategoryEntity entity: categoryEntities) {
            CategoryDTO dto = entityToDTO(entity);
            dtoList.add(dto);
        }


        return dtoList;
    }

    @Override
    public List<CategoryEntity> dtoListTOEntityList(List<CategoryDTO> categoryDTOS) {
        List<CategoryEntity> entityList = new ArrayList<>();
        for (CategoryDTO dto: categoryDTOS) {
            CategoryEntity entity = dtoToEntity(dto);
            entityList.add(entity);
        }
        return entityList;
    }

    @Override
    public CategoryEntity requestDTOToEntity(CategoryRequestDTO dto) {
        CategoryEntity entity = new CategoryEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        return entity;
    }

    @Override
    public List<CategoryEntity> requestDtoListTOEntityList(List<CategoryRequestDTO> categoryRequestDTOS) {
        return null;
    }

    @Override
    public CategoryEntity requestDTOToExistEntity(CategoryRequestDTO categoryRequestDTO, CategoryEntity entity) {
        return null;
    }

    @Override
    public PageDTO<CategoryDTO> pageEntityToPageDTO(Page<CategoryEntity> entityPage) {
        PageDTO<CategoryDTO> pageDTO = new PageDTO<>();
        pageDTO.setContent(entityListToDTOList(entityPage.getContent()));
        pageDTO.setTotalPages(entityPage.getTotalPages());
        pageDTO.setSize(entityPage.getSize());
        pageDTO.setNumber(entityPage.getNumber());
        pageDTO.setSort(entityPage.getSort());
        pageDTO.setTotalElements(entityPage.getTotalElements());
        pageDTO.setNumberOfElements(entityPage.getNumberOfElements());

        return pageDTO;

    }
}
