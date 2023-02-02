package ru.gb.springone.market.springcart.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.db.springone.market.api.ProductDto;
import ru.gb.springone.market.springcart.integrations.ProductServiceIntegration;
import ru.gb.springone.market.springcart.models.Cart;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductServiceIntegration productServiceIntegration;
    private Map<String, Cart> tempCart;

    @PostConstruct
    public void init() {
        tempCart = new HashMap<>();
        tempCart.put("guest", new Cart());
    }


    public Cart getCurrentCart(String username) {
        if (username != null) {
            Cart cart = tempCart.get(username);
            if (Objects.nonNull(cart)) {
                return cart;
            } else {
                tempCart.put(username, new Cart());
                return tempCart.get(username);
            }
        } else return tempCart.get("guest");
    }

    public void add(String username, Long productId) {
        ProductDto product = productServiceIntegration.getProductById(productId);
        getCurrentCart(username).add(product);
    }

    public void remove(String username,Long productId) {
        getCurrentCart(username).remove(productId);
    }

    public void clear(String username) {
        getCurrentCart(username).clear();
    }
}
