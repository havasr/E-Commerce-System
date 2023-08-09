package com.allianz.ecommerceproject.model;

import com.allianz.ecommerceproject.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO extends BaseDTO {
    private PersonDTO person;
    private Boolean isCorporate;
    private String companyName;
    private String taxNumber;
    private String taxOffice;
    private List<OrderDTO> orderList;

}
