package com.allianz.ecommerceproject.model.requestDTO;

import com.allianz.ecommerceproject.model.enums.OrderStatusEnum;
import com.allianz.ecommerceproject.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRequestDTO extends BaseDTO {

    private CustomerRequestDTO customer;
    private OrderStatusEnum orderStatus;
    private List<OrderItemRequestDTO> orderItemList;
    private BigDecimal totalSellPrice;
}
