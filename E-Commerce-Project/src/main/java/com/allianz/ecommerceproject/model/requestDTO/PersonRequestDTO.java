package com.allianz.ecommerceproject.model.requestDTO;

import com.allianz.ecommerceproject.util.BaseDTO;
import lombok.Data;

@Data
public class PersonRequestDTO extends BaseDTO {

    private String name;
    private String surname;
    private int birthYear;
    private String tc;

}
