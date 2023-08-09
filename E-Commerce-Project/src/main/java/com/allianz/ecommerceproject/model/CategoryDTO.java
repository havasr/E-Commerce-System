package com.allianz.ecommerceproject.model;

import com.allianz.ecommerceproject.util.BaseDTO;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CategoryDTO extends BaseDTO  {
    private String name;
    private Set<ProductDTO> productList = new HashSet<>();
}
