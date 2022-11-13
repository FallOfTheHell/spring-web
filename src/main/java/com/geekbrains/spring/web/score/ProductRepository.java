package com.geekbrains.spring.web.score;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ProductRepository {
    //private final Map<Integer, Product> productID = new HashMap<>();
    private List<Product> products;

//    {
//        productID.put(1,new Product(1, "Bad", BigDecimal.valueOf(103)));
//        productID.put(2,new Product(2, "Milk", BigDecimal.valueOf(603)));
//        productID.put(3,new Product(3, "Eggs", BigDecimal.valueOf(91)));
//        productID.put(4,new Product(4, "Sausage", BigDecimal.valueOf(181)));
//        productID.put(5,new Product(5, "Cheese", BigDecimal.valueOf(278)));
//
//    }

    @PostConstruct
    public void init(){
        products = new ArrayList<>(List.of(
                new Product(1L, "Milc", 1093),
                new Product(2L, "Bad", 103),
                new Product(3L, "Eggs", 201),
                new Product(6L, "Eat", 810),
                new Product(5L, "Cheese", 971)
        ));
        products.removeIf(s -> false);
    }

//    public List<Product> findAll(){
//        return new ArrayList<>(productID.values());
//    }

//    public void saveOrUpdate(Product product){
//        if (product.getId() == null){
//            Integer id = productID.size() + 1;
//            product.setId(id);
//        }
//        productID.put(product.getId(), product);
//    }

//    public Product findById(int id){
//        return productID.get(id);
//    }
//
//    public Product deleteById(int id){
//        return productID.remove(id);
//    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product findById(Long id) {
        return products.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}

