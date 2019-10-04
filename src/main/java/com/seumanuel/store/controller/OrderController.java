package com.seumanuel.store.controller;


import com.seumanuel.store.model.Order;
import com.seumanuel.store.model.OrderStatus;
import com.seumanuel.store.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable String id) {
        return orderService.findById(id);
    }

    @PostMapping
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    @GetMapping
    public Order cancel(@RequestBody Order order) {
        if(!OrderStatus.NEW.equals(order.getStatus())){
            throw new IllegalStateException("Can't cancel that order!");
        }
        return orderService.cancel(order);
    }

    @GetMapping
    public Order confirmOrder(@RequestBody Order order) {
        return orderService.confirmOrder(order);
    }

    @GetMapping
    public Order deliverOrder(@RequestBody Order order) {
        return orderService.deliverOrder(order);
    }

    @GetMapping()
    public List<Order> findAllByName(@RequestParam String buyerName){
        return orderService.findAllByName(buyerName);
    }
}
