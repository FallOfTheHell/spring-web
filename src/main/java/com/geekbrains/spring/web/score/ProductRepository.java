package com.geekbrains.spring.web.score;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>(List.of(
                new Product(1L, "Milc", 1000),
                new Product(2L, "Bad", 100),
                new Product(3L, "Eggs", 200),
                new Product(4L, "Eat", 810),
                new Product(5L, "Cheese", 970)
        ));
        products.removeIf(s -> false);
    }


    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product findById(Long id) {
        return products.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }


    public void delProduct(Long id) {
        products.removeIf(s -> s.getId().equals(id));
    }

    public void addProduct(Product p){
        products.add(p);
    }

}

