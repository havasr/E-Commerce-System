package com.allianz.ecommerceproject.model.requestDTO;

import com.allianz.ecommerceproject.util.BaseDTO;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CategoryRequestDTO extends BaseDTO {
    private String name;
    private Set<ProductRequestDTO> productList = new HashSet<>();
}
