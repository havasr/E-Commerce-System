package com.allianz.ecommerceproject.model;

import com.allianz.ecommerceproject.util.BaseDTO;
import lombok.Data;

@Data
public class AddressDTO extends BaseDTO {

    private String title;
    private String address;

    //private PersonDTO person;

}
