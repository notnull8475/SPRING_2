package ru.gb.SpringOne.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.db.springone.market.api.OrderDto;
import ru.gb.SpringOne.services.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestHeader String username /*, @RequestBody OrderData orderData */) {
        orderService.createOrder(username);
    }

    @GetMapping
    public List<OrderDto> getOrders(){
        orderService.
    }
}
