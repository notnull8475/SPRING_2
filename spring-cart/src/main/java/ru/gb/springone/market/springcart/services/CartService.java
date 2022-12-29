package ru.gb.springone.market.springcart.services;

import org.springframework.stereotype.Service;
import ru.gb.springone.market.springcart.models.Cart;

@Service
public class CartService {
    public void add(Long id) {
    }

    public void clear() {
    }

    public void remove(Long id) {
    }

    public Cart getCurrentCart() {
        return new Cart();
    }
}
