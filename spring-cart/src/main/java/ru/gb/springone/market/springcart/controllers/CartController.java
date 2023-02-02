package ru.gb.springone.market.springcart.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.db.springone.market.api.CartDto;
import ru.gb.springone.market.springcart.converters.CartConverter;
import ru.gb.springone.market.springcart.services.CartService;

import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/carts")
public class CartController {
    private final CartService cartService;
    private final CartConverter cartConverter;

    @GetMapping("/add/{id}")
    public void addToCart(@RequestHeader(required = false) String username,@PathVariable Long id) {
        cartService.add(username,id);
    }

    @GetMapping("/clear")
    public void clearCart(@RequestHeader(required = false) String username) {
        cartService.clear(username);
    }

    @GetMapping("/remove/{id}")
    public void removeFromCart(@RequestHeader(required = false) String username,@PathVariable Long id) {
        cartService.remove(username,id);
    }

    @GetMapping
    public CartDto getCurrentCart(@RequestHeader(required = false) String username) {
        return cartConverter.entityToDto(cartService.getCurrentCart(username));
    }

}
