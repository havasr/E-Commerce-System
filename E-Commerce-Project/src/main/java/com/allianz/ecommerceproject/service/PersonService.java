package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.PersonEntity;
import com.allianz.ecommerceproject.database.repository.PersonEntityRepository;
import com.allianz.ecommerceproject.mapper.PersonMapper;
import com.allianz.ecommerceproject.model.PersonDTO;
import com.allianz.ecommerceproject.model.requestDTO.PersonRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService extends BaseService<PersonDTO, PersonEntity, PersonRequestDTO> {

    @Autowired
    PersonEntityRepository personEntityRepository;
    @Autowired
    PersonMapper personMapper;

    @Override
    public PersonDTO save(PersonRequestDTO requestDTO) {
        PersonEntity personEntity = personMapper.requestDTOToEntity(requestDTO);
        personEntityRepository.save(personEntity);
        return personMapper.entityToDTO(personEntity);
    }

    @Override
    public List<PersonDTO> getAll() {
        List<PersonEntity> personEntities = personEntityRepository.findAll();
        return personMapper.entityListToDTOList(personEntities);
    }

    @Override
    public PersonDTO update(UUID uuid, PersonRequestDTO requestDTO) {
        PersonEntity personEntity = personEntityRepository.findByUuid(uuid).orElse(null);
        if (personEntity == null){
            return null;
        }
        return personMapper.entityToDTO(personEntityRepository
                .save(personMapper.requestDTOToExistEntity(requestDTO, personEntity)));
    }

    @Override
    public Boolean delete(UUID uuid) {
        PersonEntity personEntity = personEntityRepository.findByUuid(uuid).orElse(null);
        if (personEntity == null){
            return false;
        }
        personEntityRepository.delete(personEntity);
        return true;
    }

    @Override
    public PersonDTO getByUuid(UUID uuid) {
        PersonEntity personEntity = personEntityRepository.findByUuid(uuid).orElse(null);
        if (personEntity == null){
            return null;
        }
        return personMapper.entityToDTO(personEntity);
    }
}
