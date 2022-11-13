package com.geekbrains.spring.web.score;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cart {
    //private final Map<Product, Integer> cartMap = new HashMap<>();
    private final List<Product> product = new ArrayList<>();

//    public Map<Product, Integer> getCartMap(){
//        return cartMap;
//    }

//    public void addProduct(Product product, Integer quantity){
//        if (product != null)
//            cartMap.merge(product, quantity, Integer::sum);
//    }


    public void addProduct(Long id, String title, Integer cost){
        product.add(new Product(id, title, cost));
    }

    public void delProduct(Long id){
        product.remove(id);
    }

//    public void delProduct(Product product, Integer quantity){
//        if (cartMap.containsKey(product)){
//            if (quantity != null && cartMap.get(product).compareTo(quantity) > 0){
//                cartMap.put(product, cartMap.get(product) - quantity);
//            } else {
//                cartMap.remove(product);
//            }
//        }
//    }

//    public BigDecimal getSum(){
//        BigDecimal sum = BigDecimal.valueOf(0);
//        for (Map.Entry<Product, Integer> entry: cartMap.entrySet()) {
//            sum = sum.add(entry.getKey().getCost().multiply(BigDecimal.valueOf(entry.getValue())));
//        }
//        return sum;
//    }
}
