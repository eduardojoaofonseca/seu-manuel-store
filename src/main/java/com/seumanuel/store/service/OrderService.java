package com.seumanuel.store.service;

import com.seumanuel.store.model.Order;
import com.seumanuel.store.model.OrderProduct;
import com.seumanuel.store.model.OrderStatus;
import com.seumanuel.store.repository.OrderRepository;
import org.springframework.stereotype.Service;

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
        if(OrderStatus.NEW.equals(order.getStatus())){
            order.setStatus(OrderStatus.CANCELLED);
            return orderRepository.save(order);
        }

        return null;
    }

    public Order confirmOrder(Order order) {
        order.setStatus(OrderStatus.APPROVED);
        return orderRepository.save(order);
    }

    public Order deliverOrder(Order order) {
        order.setStatus(OrderStatus.DELIVERED);
        return orderRepository.save(order);
    }
}
