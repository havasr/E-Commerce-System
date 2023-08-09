package com.allianz.ecommerceproject.model;

import com.allianz.ecommerceproject.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO extends BaseDTO {
    private ProductDTO product;
    private Integer quantity;
    private BigDecimal sellPrice;
}
