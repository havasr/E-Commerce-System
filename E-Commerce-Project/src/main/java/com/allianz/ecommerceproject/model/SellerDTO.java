package com.allianz.ecommerceproject.model;

import com.allianz.ecommerceproject.util.BaseDTO;
import lombok.Data;

@Data
public class SellerDTO extends BaseDTO {

    private String name;
    private String surname;
    private String tc;
    private String email;
    private String shopName;
    private String taxNumber;
    private String taxOffice;

}
