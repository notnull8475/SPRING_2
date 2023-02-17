package ru.gb.springone.market.springcart.controllers;

import org.springframework.web.bind.annotation.*;
import ru.db.springone.market.api.CartDto;
import ru.db.springone.market.api.CartMergeRequest;
import ru.db.springone.market.api.ChangeQuantityRequest;
import ru.db.springone.market.api.StringResponse;
import ru.gb.springone.market.springcart.converters.CartConverter;
import ru.gb.springone.market.springcart.services.CartService;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/carts")
public class CartController {
    private final CartService cartService;
    private final CartConverter cartConverter;

    public CartController(CartService cartService, CartConverter cartConverter) {
        this.cartService = cartService;
        this.cartConverter = cartConverter;
    }


    @GetMapping("/generate_uuid")
    public StringResponse generateUuid() {
        return new StringResponse(UUID.randomUUID().toString());
    }


    @PostMapping("/merge")
    public void mergeCarts(@RequestBody CartMergeRequest mergeRequest) {
        cartService.merge(mergeRequest);
    }

    @GetMapping("/{uuid}/add/{id}")
    public CartDto addToCart(@RequestHeader(name = "username", required = false) String username, @PathVariable String uuid, @PathVariable Long id) {
        String targetUuid = getCartUuid(username, uuid);
        return cartConverter.entityToDto(cartService.add(targetUuid, id));
    }

    @GetMapping("/{uuid}/clear")
    public void clearCart(@RequestHeader(name = "username", required = false) String username, @PathVariable String uuid) {
        String targetUuid = getCartUuid(username, uuid);
        cartService.clear(targetUuid);
    }

    @GetMapping("/{uuid}/remove/{id}")
    public void removeFromCart(@RequestHeader(name = "username", required = false) String username, @PathVariable String uuid, @PathVariable Long id) {
        String targetUuid = getCartUuid(username, uuid);
        cartService.remove(targetUuid, id);
    }

    @GetMapping("/{uuid}")
    public CartDto getCurrentCart(@RequestHeader(name = "username", required = false) String username, @PathVariable String uuid) {
        String targetUuid = getCartUuid(username, uuid);
        return cartConverter.entityToDto(cartService.getCurrentCart(targetUuid));
    }


    @PutMapping("/{uuid}/change/")
    public void changeQuantity(@RequestBody ChangeQuantityRequest changeQuantityRequest,
                               @PathVariable String uuid) {
        System.out.println("##########################change quantity " + changeQuantityRequest.toString());
        String targetUuid = getCartUuid(changeQuantityRequest.getUsername(), uuid);
        cartService.chageQuantity(targetUuid, changeQuantityRequest.getDelta(), changeQuantityRequest.getIndex());
    }


    private String getCartUuid(String username, String uuid) {
        if (username != null) {
            return username;
        }
        return uuid;
    }

}
