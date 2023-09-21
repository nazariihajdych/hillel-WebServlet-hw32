package ua.ithillel.orderapp.model;

import lombok.Data;

@Data
public class Product {
    private Integer id;
    private String name;
    private Double cost;
}
