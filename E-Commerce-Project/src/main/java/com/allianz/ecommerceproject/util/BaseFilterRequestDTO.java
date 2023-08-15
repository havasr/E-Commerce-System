package com.allianz.ecommerceproject.util;

import com.allianz.ecommerceproject.model.SortDTO;
import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class BaseFilterRequestDTO {
    private int pageNumber;
    private int pageSize;
    private SortDTO sort;

}
