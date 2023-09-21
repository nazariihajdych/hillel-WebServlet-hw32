package ua.ithillel.orderapp.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Order {
    private Integer id;
    private Date date;
    private Double cost;
    private List<Product> products;

    public Order() {
        this.date = new Date();
        this.products = new ArrayList<>();
    }
}
