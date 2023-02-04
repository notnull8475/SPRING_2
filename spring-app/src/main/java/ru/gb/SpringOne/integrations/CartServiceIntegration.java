package ru.gb.SpringOne.integrations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.db.springone.market.api.CartDto;
import ru.db.springone.market.api.CartMergeRequest;

@Component
@RequiredArgsConstructor
public class CartServiceIntegration {
    private final WebClient cartServiceWebClient;

    public CartDto getCurrentCart(String username) {
        return cartServiceWebClient.get()
                .uri("/api/v1/cart")
                .header("username", username)
                .retrieve()
                .bodyToMono(CartDto.class)
                .block();
    }

    public void clear(String username) {
        cartServiceWebClient.get()
                .uri("/api/v1/cart/clear")
                .header("username", username)
                .retrieve()
                .toBodilessEntity()
                .block();
    }

    public void mergeCarts(String username, String uuid) {
        cartServiceWebClient.post()
                .uri("/api/v1/cart/merge")
                .bodyValue(new CartMergeRequest(username,uuid))
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}
