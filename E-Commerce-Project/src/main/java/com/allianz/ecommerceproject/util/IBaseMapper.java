package com.allianz.ecommerceproject.util;

import com.allianz.ecommerceproject.model.PageDTO;
import com.allianz.ecommerceproject.util.dbutil.BaseEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBaseMapper<DTO extends BaseDTO, Entity extends BaseEntity, RequestDTO extends BaseDTO> {

    DTO entityToDTO(Entity entity);

    Entity dtoToEntity(DTO dto);

    List<DTO> entityListToDTOList(List<Entity> entityList);

    List<Entity> dtoListTOEntityList(List<DTO> dtoList);

    Entity requestDTOToEntity(RequestDTO dto);

    List<Entity> requestDtoListTOEntityList(List<RequestDTO> dtoList);

    Entity requestDTOToExistEntity(RequestDTO requestDTO, Entity entity);

    PageDTO<DTO> pageEntityToPageDTO(Page<Entity> entityPage);

}
