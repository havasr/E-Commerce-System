package com.allianz.ecommerceproject.model.requestDTO;

import com.allianz.ecommerceproject.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BillRequestDTO extends BaseDTO {
    private String billNo;
    private LocalDateTime billDate;
    private BigDecimal taxRate;
    private BigDecimal taxAmount;
    private BigDecimal totalSellNetPrice;
    private BigDecimal totalSellPrice;
    private OrderRequestDTO order;
}
