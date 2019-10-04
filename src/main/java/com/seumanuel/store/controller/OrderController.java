package com.seumanuel.store.controller;


import com.seumanuel.store.model.Order;
import com.seumanuel.store.model.OrderStatus;
import com.seumanuel.store.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    public Order cancel(@RequestBody Order order) {
        if(OrderStatus.NEW.equals(order.getStatus())){
            return orderService.cancel(order);
        }
        return null;
    }

    public Order confirmOrder(@RequestBody Order order) {
        order.setStatus(OrderStatus.APPROVED);
        return orderService.save(order);
    }

    public Order deliverOrder(@RequestBody Order order) {
        order.setStatus(OrderStatus.DELIVERED);
        return orderService.save(order);
    }
}
