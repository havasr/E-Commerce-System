package com.allianz.ecommerceproject.model;

import com.allianz.ecommerceproject.util.BaseDTO;
import lombok.Data;

@Data
public class SettingDTO extends BaseDTO {
    private String key;
    private String value;
}
