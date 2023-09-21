package ua.ithillel.orderapp.repo;

import org.springframework.stereotype.Repository;
import ua.ithillel.orderapp.model.Order;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepoDefault implements OrderRepo {
    private final List<Order> orderList = new ArrayList<>();

    @Override
    public Order getOrderById(Integer id) {
        return orderList.stream().
                filter(order -> order.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderList;
    }

    @Override
    public Order addOrder(Order order) {
        orderList.add(order);
        return order;
    }
}
