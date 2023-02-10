package ru.gb.SpringOne.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.db.springone.market.api.CartDto;
import ru.db.springone.market.api.OrderDto;
import ru.gb.SpringOne.integrations.CartServiceIntegration;
import ru.gb.SpringOne.models.Order;
import ru.gb.SpringOne.models.OrderItem;
import ru.gb.SpringOne.repositories.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderService {
    private final ProductService productService;
    private final OrderRepository orderRepository;
    private final CartServiceIntegration cartServiceIntegration;

    @Transactional
    public Order createOrder(String username) {
        CartDto cartDto = cartServiceIntegration.getCurrentCart(username);
        Order order = new Order();
        order.setUsername(username);
        order.setTotalPrice(cartDto.getTotalPrice());
        order.setItems(cartDto.getItems().stream().map(
                cartItem -> new OrderItem(
                        productService.getProduct(cartItem.getProductId()).get(),
                        order,
                        cartItem.getQuantity(),
                        cartItem.getPricePerProduct(),
                        cartItem.getPrice()
                )
        ).collect(Collectors.toList()));
        orderRepository.save(order);
        cartServiceIntegration.clear(username);
        return order;
    }


    public List<Order> findAllByUsername(String username) {
        return orderRepository.findAllByUsername(username);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
