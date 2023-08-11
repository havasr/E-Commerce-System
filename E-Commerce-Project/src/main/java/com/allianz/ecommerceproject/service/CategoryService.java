package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.CategoryEntity;
import com.allianz.ecommerceproject.database.repository.CategoryEntityRepository;
import com.allianz.ecommerceproject.mapper.CategoryMapper;
import com.allianz.ecommerceproject.model.CategoryDTO;
import com.allianz.ecommerceproject.model.requestDTO.CategoryRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService extends BaseService<CategoryDTO, CategoryEntity, CategoryRequestDTO> {

    @Autowired
    CategoryEntityRepository categoryEntityRepository;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public CategoryDTO save(CategoryRequestDTO requestDTO) {
        CategoryEntity categoryEntity = categoryMapper.requestDTOToEntity(requestDTO);
        categoryEntityRepository.save(categoryEntity);
        return categoryMapper.entityToDTO(categoryEntity);
    }

    @Override
    public List<CategoryDTO> getAll() {
        List<CategoryEntity> categoryEntities = categoryEntityRepository.findAll();
        return categoryMapper.entityListToDTOList(categoryEntities);
    }

    @Override
    public CategoryDTO update(UUID uuid, CategoryRequestDTO requestDTO) {
        CategoryEntity categoryEntity = categoryEntityRepository.findByUuid(uuid).orElse(null);
        if (categoryEntity == null) {
            return null;
        }
        return categoryMapper.entityToDTO(categoryEntityRepository
                .save(categoryMapper.requestDTOToExistEntity(requestDTO, categoryEntity)));
    }

    @Override
    public Boolean delete(UUID uuid) {
        CategoryEntity categoryEntity = categoryEntityRepository.findByUuid(uuid).orElse(null);
        if (categoryEntity == null) {
            return false;
        }
        categoryEntityRepository.delete(categoryEntity);
        return true;
    }

    @Override
    public CategoryDTO getByUuid(UUID uuid) {
        CategoryEntity categoryEntity = categoryEntityRepository.findByUuid(uuid).orElse(null);
        if (categoryEntity == null) {
            return null;
        }
        return categoryMapper.entityToDTO(categoryEntity);
    }
}
