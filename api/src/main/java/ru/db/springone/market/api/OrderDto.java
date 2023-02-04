package ru.db.springone.market.api;

import java.math.BigDecimal;
import java.util.List;

public class OrderDto {
    private Long id;
    private String username;
    private List<OrderItemDto> items;
    private String address;
    private String phone;
    private BigDecimal totalPrice;
}
