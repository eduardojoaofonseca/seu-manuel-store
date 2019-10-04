package com.seumanuel.store.service;

import com.seumanuel.store.model.Order;
import com.seumanuel.store.model.OrderProduct;
import com.seumanuel.store.model.OrderStatus;
import com.seumanuel.store.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order findById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Order cancel(Order order) {
        if(!OrderStatus.NEW.equals(order.getStatus())){
            throw new IllegalStateException("Can't cancel that order!");
        }
        return orderRepository.save(order);
    }

    public Order confirmOrder(Order order) {
        order.setStatus(OrderStatus.APPROVED);
        return orderRepository.save(order);
    }

    public Order deliverOrder(Order order) {
        order.setStatus(OrderStatus.DELIVERED);
        return orderRepository.save(order);
    }

    public List<Order> findAllByName(String buyerName){
        return orderRepository.findAllByName(buyerName);
    }

}
