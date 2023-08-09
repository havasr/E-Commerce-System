package com.allianz.ecommerceproject.model.requestDTO;

import com.allianz.ecommerceproject.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemRequestDTO extends BaseDTO {
    private ProductRequestDTO product;
    private Integer quantity;
    private BigDecimal sellPrice;
}
