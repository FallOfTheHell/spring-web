package com.geekbrains.spring.web.score;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private Long id;
    private String title;
    private Integer cost;

    public Product(Long id, String title, Integer cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return String.format("id = %-2s | title = %-15s | cost = %-8s" , id, title, cost);
    }
}
