package com.allianz.ecommerceproject.model;

import com.allianz.ecommerceproject.model.enums.OrderStatusEnum;
import com.allianz.ecommerceproject.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDTO extends BaseDTO {

    private CustomerDTO customer;
    private OrderStatusEnum orderStatus;
    private List<OrderItemDTO> orderItemList;
    private BigDecimal totalSellPrice;
}
