package com.allianz.ecommerceproject.util;

import com.allianz.ecommerceproject.util.dbutil.BaseEntity;
import com.allianz.ecommerceproject.util.dbutil.IBaseRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.UUID;

@NoRepositoryBean
public abstract class BaseService<DTO extends BaseDTO, Entity extends BaseEntity, RequestDTO extends BaseDTO,
        repository extends IBaseRepository<Entity>, mapper extends IBaseMapper<DTO, Entity, RequestDTO>> {

    protected abstract mapper getBaseMapper();

    protected abstract repository getBaseRepository();


    public DTO save(RequestDTO dto) {
        Entity entity = getBaseMapper().requestDTOToEntity(dto);
        getBaseRepository().save(entity);
        return getBaseMapper().entityToDTO(entity);
    }

    public List<DTO> getAll() {
        List<Entity> entityList = getBaseRepository().findAll();
        return getBaseMapper().entityListToDTOList(entityList);
    }

    public DTO update(UUID uuid, RequestDTO requestDTO){
        Entity entity =  getBaseRepository().findByUuid(uuid).orElse(null);
        if (entity == null){
            return null;
        }
        return getBaseMapper().entityToDTO( getBaseRepository()
                .save(getBaseMapper().requestDTOToExistEntity(requestDTO, entity)));

    }

    public Boolean delete(UUID uuid){
        Entity entity = getBaseRepository().findByUuid(uuid).orElse(null);
        if (entity == null){
            return false;
        }
        getBaseRepository().delete(entity);
        return true;
    }


    public DTO getByUuid(UUID uuid) {
        Entity entity =  getBaseRepository().findByUuid(uuid).orElse(null);
        if (entity == null) {
            return null;
        }
        return getBaseMapper().entityToDTO(entity);
    }

}
