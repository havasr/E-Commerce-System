package com.allianz.ecommerceproject.model.requestDTO;

import com.allianz.ecommerceproject.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaxRequestDTO extends BaseDTO {
    private String name;
    private String code;
    private BigDecimal rate;
}
