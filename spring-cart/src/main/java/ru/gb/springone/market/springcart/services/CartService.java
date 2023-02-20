package ru.gb.springone.market.springcart.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import ru.db.springone.market.api.CartMergeRequest;
import ru.db.springone.market.api.ProductDto;
import ru.gb.springone.market.springcart.integrations.ProductServiceIntegration;
import ru.gb.springone.market.springcart.models.Cart;
import ru.gb.springone.market.springcart.models.CartItem;

import java.util.List;
import java.util.function.Consumer;

@Service
public class CartService {
    @Autowired
    private  ProductServiceIntegration productServiceIntegration;

    /* Как понял из урока - данное использование Redis является реализацией структурного паттерна прокси.  * */

    @Autowired
    private  RedisTemplate<String, Object> redisTemplate;

    @Value("${cart-service.cart-prefix}")
    private String cartPrefix;// = "CARTSERVICE";

    public Cart getCurrentCart(String uuid) {
        String targetUuid = cartPrefix + uuid;
//        Boolean flag = ;
        if (Boolean.FALSE.equals(redisTemplate.hasKey(targetUuid))) {
            redisTemplate.opsForValue().set(targetUuid, new Cart());
        }
        return (Cart) redisTemplate.opsForValue().get(targetUuid);
    }

    public Cart add(String uuid, Long productId) {
        ProductDto product = productServiceIntegration.getProductById(productId);
        return execute(uuid, cart -> cart.add(product));
    }

    public void remove(String uuid, Long productId) {
        execute(uuid, cart -> cart.remove(productId));
    }

    public void clear(String uuid) {
        execute(uuid, Cart::clear);
    }

    private Cart execute(String uuid, Consumer<Cart> operation) {
        Cart cart = getCurrentCart(uuid);
        operation.accept(cart);
        redisTemplate.opsForValue().set(cartPrefix + uuid, cart);
        return cart;
    }

    public void merge(CartMergeRequest mergeRequest) {
        Cart cartNonAuth = getCurrentCart(mergeRequest.getUUID());
        List<CartItem> items = cartNonAuth.getItems();
        execute(mergeRequest.getUsername(), cart -> cart.addItems(items));
    }

    public void chageQuantity(String targetUuid, int delta, int index) {
        execute(targetUuid,c -> {
            c.getItems().get(index).changeQuantity(delta);
        });
    }
}
