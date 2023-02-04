package ru.db.springone.market.api;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderItemDto {
    private Long id;
    private String productTitle ;
    private Long orderId;
    private int quantity;
    private BigDecimal pricePerProduct;
    private BigDecimal price;
}
