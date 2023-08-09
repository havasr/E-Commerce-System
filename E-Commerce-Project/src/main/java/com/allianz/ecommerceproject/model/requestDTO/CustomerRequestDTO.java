package com.allianz.ecommerceproject.model.requestDTO;


import com.allianz.ecommerceproject.model.PersonDTO;
import com.allianz.ecommerceproject.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class CustomerRequestDTO extends BaseDTO {
    private PersonDTO person;
    private Boolean isCorporate;
    private String companyName;
    private String taxNumber;
    private String taxOffice;
    private List<OrderRequestDTO> orderList;

}
