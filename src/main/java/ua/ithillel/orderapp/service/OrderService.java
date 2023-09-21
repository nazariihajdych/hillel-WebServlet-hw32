package ua.ithillel.orderapp.service;

import ua.ithillel.orderapp.model.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(Integer id);
    List<Order> getAllOrders();
    Order addOrder(Order order);
}
