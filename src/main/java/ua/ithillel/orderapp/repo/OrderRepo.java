package ua.ithillel.orderapp.repo;

import ua.ithillel.orderapp.model.Order;

import java.util.List;

public interface OrderRepo {
    Order getOrderById(Integer id);
    List<Order> getAllOrders();
    Order addOrder(Order order);
}
