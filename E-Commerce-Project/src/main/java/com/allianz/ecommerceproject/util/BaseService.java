package com.allianz.ecommerceproject.util;

import com.allianz.ecommerceproject.model.PageDTO;
import com.allianz.ecommerceproject.util.dbutil.BaseEntity;
import com.allianz.ecommerceproject.util.dbutil.IBaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

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

    public PageDTO<DTO> getAll(BaseFilterRequestDTO baseFilterRequestDTO) {
        Pageable pageable = null;
        if (baseFilterRequestDTO.getSort() != null){
            if (baseFilterRequestDTO.getSort().getDirectionEnum() == Sort.Direction.DESC){
                pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(), baseFilterRequestDTO.getPageSize(),
                        Sort.by(baseFilterRequestDTO.getSort().getColumnName()).descending());

            } else {
                pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(), baseFilterRequestDTO.getPageSize(),
                        Sort.by(baseFilterRequestDTO.getSort().getColumnName()).ascending());
            }
        }  else {
            pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(), baseFilterRequestDTO.getPageSize(),
                    Sort.by("id").ascending());
        }

        Page<Entity> entityPage = getBaseRepository().findAll(pageable);

        return getBaseMapper().pageEntityToPageDTO(entityPage);
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
