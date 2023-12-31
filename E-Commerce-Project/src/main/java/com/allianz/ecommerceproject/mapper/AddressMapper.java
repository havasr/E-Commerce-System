package com.allianz.ecommerceproject.mapper;

import com.allianz.ecommerceproject.database.entity.AddressEntity;
import com.allianz.ecommerceproject.model.AddressDTO;
import com.allianz.ecommerceproject.model.PageDTO;
import com.allianz.ecommerceproject.model.requestDTO.AddressRequestDTO;
import com.allianz.ecommerceproject.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressMapper implements IBaseMapper<AddressDTO, AddressEntity, AddressRequestDTO> {
    @Override
    public AddressDTO entityToDTO(AddressEntity entity) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCreationDate(entity.getCreationDate());
        addressDTO.setUuid(entity.getUuid());
        addressDTO.setId(entity.getId());
        addressDTO.setAddress(entity.getAddress());
        addressDTO.setTitle(entity.getTitle());
        addressDTO.setUpdatedDate(entity.getUpdatedDate());

        return addressDTO;
    }

    @Override
    public AddressEntity dtoToEntity(AddressDTO dto) {
        return null;
    }

    @Override
    public List<AddressDTO> entityListToDTOList(List<AddressEntity> addressEntities) {
        List<AddressDTO> addressDTOList = new ArrayList<>();

        for (AddressEntity addressEntity:addressEntities) {
            addressDTOList.add(entityToDTO(addressEntity));
        }
        
        return addressDTOList;
    }

    @Override
    public List<AddressEntity> dtoListTOEntityList(List<AddressDTO> addressDTOS) {
        return null;
    }

    @Override
    public AddressEntity requestDTOToEntity(AddressRequestDTO dto) {
        AddressEntity entity = new AddressEntity();

        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;
    }

    @Override
    public List<AddressEntity> requestDtoListTOEntityList(List<AddressRequestDTO> addressRequestDTOS) {
        return null;
    }

    @Override
    public AddressEntity requestDTOToExistEntity(AddressRequestDTO addressRequestDTO, AddressEntity entity) {
        return null;
    }

    @Override
    public PageDTO<AddressDTO> pageEntityToPageDTO(Page<AddressEntity> entityPage) {
        PageDTO<AddressDTO> pageDTO = new PageDTO<>();
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
