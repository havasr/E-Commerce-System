package com.allianz.ecommerceproject.model;

import com.allianz.ecommerceproject.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaxDTO extends BaseDTO {
    private String name;
    private String code;
    private BigDecimal rate;
}
