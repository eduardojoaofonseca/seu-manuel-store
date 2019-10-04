package com.seumanuel.store.helper;

import com.seumanuel.store.model.Order;
import com.seumanuel.store.model.OrderProduct;
import com.seumanuel.store.model.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public final class OrderHelper {

    private OrderHelper(){

    }

    public static Order newOrder(String id, String buyerName, LocalDateTime now ,BigDecimal shipmentPrice, List<OrderProduct> content) {
        Order order = new Order();

        order.setId(id);
        order.setDateHourPurchase(now);
        order.setBuyerName(buyerName);
        order.setStatus(OrderStatus.NEW);
        order.setShipmentPrice(shipmentPrice);
        order.setOrderProducts(content);

        return order;
    }
}
