package com.allianz.ecommerceproject.service;

import com.allianz.ecommerceproject.database.entity.AddressEntity;
import com.allianz.ecommerceproject.database.repository.AddressEntityRepository;
import com.allianz.ecommerceproject.mapper.AddressMapper;
import com.allianz.ecommerceproject.model.AddressDTO;
import com.allianz.ecommerceproject.model.requestDTO.AddressRequestDTO;
import com.allianz.ecommerceproject.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService extends BaseService<AddressDTO, AddressEntity, AddressRequestDTO> {

    @Autowired
    AddressEntityRepository addressEntityRepository;

    @Autowired
    AddressMapper addressMapper;

    @Override
    public AddressDTO save(AddressRequestDTO dto) {
        AddressEntity addressEntity = addressMapper.requestDTOToEntity(dto);
        addressEntityRepository.save(addressEntity);
        return addressMapper.entityToDTO(addressEntity);
    }

    @Override
    public List<AddressDTO> getAll() {
        List<AddressEntity> addressEntityList = addressEntityRepository.findAll();
        return addressMapper.entityListToDTOList(addressEntityList);
    }

    @Override
    public AddressDTO update(UUID uuid, AddressRequestDTO requestDTO){
        AddressEntity addressEntity = addressEntityRepository.findByUuid(uuid).orElse(null);
        if (addressEntity == null){
            return null;
        }
        return addressMapper.entityToDTO(addressEntityRepository
                .save(addressMapper.requestDTOToExistEntity(requestDTO, addressEntity)));

    }

    @Override
    public Boolean delete(UUID uuid){
        AddressEntity addressEntity = addressEntityRepository.findByUuid(uuid).orElse(null);
        if (addressEntity == null){
            return false;
        }
        addressEntityRepository.delete(addressEntity);
        return true;
    }

    @Override
    public AddressDTO getByUuid(UUID uuid) {
        AddressEntity addressEntity = addressEntityRepository.findByUuid(uuid).orElse(null);
        if (addressEntity == null) {
            return null;
        }
        return addressMapper.entityToDTO(addressEntity);
    }


}
