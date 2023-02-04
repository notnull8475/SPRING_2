package ru.gb.springone.market.auth.integrations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.db.springone.market.api.CartDto;
import ru.db.springone.market.api.CartMergeRequest;

@Component
@RequiredArgsConstructor
public class CartServiceIntegration {
    private final WebClient cartServiceWebClient;

    public void mergeCarts(String username, String uuid) {
        cartServiceWebClient.post()
                .uri("/api/v1/cart/merge")
                .bodyValue(new CartMergeRequest(username,uuid))
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}
