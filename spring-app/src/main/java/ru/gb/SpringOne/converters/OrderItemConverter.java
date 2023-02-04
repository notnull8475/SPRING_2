package ru.gb.SpringOne.converters;

import org.springframework.stereotype.Component;
import ru.db.springone.market.api.OrderItemDto;
import ru.gb.SpringOne.models.OrderItem;

@Component
public class OrderItemConverter {
    public OrderItemDto entityToDto(OrderItem orderItem) {
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(orderItem.getId());
        orderItemDto.setPrice(orderItem.getPrice());
        orderItemDto.setPricePerProduct(orderItem.getPricePerProduct());
        orderItemDto.setQuantity(orderItem.getQuantity());
        orderItemDto.setProductTitle(orderItem.getProduct().getTitle());
        orderItemDto.setProductId(orderItem.getProduct().getId());
        return orderItemDto;
    }
}
