package com.allianz.ecommerceproject.model.requestDTO;

import com.allianz.ecommerceproject.util.BaseDTO;
import lombok.Data;

@Data
public class SettingRequestDTO extends BaseDTO {
    private String key;
    private String value;
}
