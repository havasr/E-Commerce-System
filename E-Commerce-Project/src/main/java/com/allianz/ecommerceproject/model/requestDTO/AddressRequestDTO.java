package com.allianz.ecommerceproject.model.requestDTO;

import com.allianz.ecommerceproject.util.BaseDTO;
import lombok.Data;

@Data
public class AddressRequestDTO extends BaseDTO {

    private String title;
    private String address;
}
