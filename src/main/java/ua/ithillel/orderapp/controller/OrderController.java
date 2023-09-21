package ua.ithillel.orderapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.orderapp.model.Order;
import ua.ithillel.orderapp.service.OrderServiceDefault;

import java.util.List;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderServiceDefault orderServiceDefault;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Order> getOrderById(@PathVariable Integer id){
        if (orderServiceDefault.getOrderById(id) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(orderServiceDefault.getOrderById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok(orderServiceDefault.getAllOrders());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Order> saveOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderServiceDefault.addOrder(order));
    }
}
