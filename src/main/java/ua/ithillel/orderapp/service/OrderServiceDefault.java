package ua.ithillel.orderapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ithillel.orderapp.model.Order;
import ua.ithillel.orderapp.model.Product;
import ua.ithillel.orderapp.repo.OrderRepoDefault;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceDefault implements OrderService {
    private final OrderRepoDefault orderRepoDefault;

    @Override
    public Order getOrderById(Integer id) {
        return orderRepoDefault.getOrderById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepoDefault.getAllOrders();
    }

    @Override
    public Order addOrder(Order order) {
        Double costOfProductsInOrder = 0D;
        for (Product p : order.getProducts()) {
            costOfProductsInOrder += p.getCost();
        }
        order.setCost(costOfProductsInOrder);
        orderRepoDefault.addOrder(order);
        order.setId(orderRepoDefault.getAllOrders().size());
        return order;
    }
}
