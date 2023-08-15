package com.allianz.ecommerceproject.mapper;

import com.allianz.ecommerceproject.database.entity.PersonEntity;
import com.allianz.ecommerceproject.model.AddressDTO;
import com.allianz.ecommerceproject.model.PageDTO;
import com.allianz.ecommerceproject.model.PersonDTO;
import com.allianz.ecommerceproject.model.requestDTO.PersonRequestDTO;
import com.allianz.ecommerceproject.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonMapper implements IBaseMapper<PersonDTO, PersonEntity, PersonRequestDTO> {


    @Override
    public PersonDTO entityToDTO(PersonEntity entity) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setTc(entity.getTc());
        personDTO.setName(entity.getName());
        personDTO.setSurname(entity.getSurname());
        personDTO.setId(entity.getId());
        personDTO.setUuid(entity.getUuid());
        personDTO.setBirthYear(entity.getBirthYear());
        personDTO.setCreationDate(entity.getCreationDate());
        personDTO.setUpdatedDate(entity.getUpdatedDate());

        return null;
    }

    @Override
    public PersonEntity dtoToEntity(PersonDTO dto) {
        return null;
    }

    @Override
    public List<PersonDTO> entityListToDTOList(List<PersonEntity> personEntities) {
        return null;
    }

    @Override
    public List<PersonEntity> dtoListTOEntityList(List<PersonDTO> personDTOS) {
        return null;
    }

    @Override
    public PersonEntity requestDTOToEntity(PersonRequestDTO dto) {
        return null;
    }

    @Override
    public List<PersonEntity> requestDtoListTOEntityList(List<PersonRequestDTO> personRequestDTOS) {
        return null;
    }

    @Override
    public PersonEntity requestDTOToExistEntity(PersonRequestDTO personRequestDTO, PersonEntity entity) {
        return null;
    }

    @Override
    public PageDTO<PersonDTO> pageEntityToPageDTO(Page<PersonEntity> entityPage) {
        PageDTO<PersonDTO> pageDTO = new PageDTO<>();
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
