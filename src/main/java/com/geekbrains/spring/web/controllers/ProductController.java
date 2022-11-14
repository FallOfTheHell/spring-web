package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.score.Product;
import com.geekbrains.spring.web.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }

    @GetMapping("/products/change_cost")
    public void changeCost(@RequestParam Long productId, @RequestParam Integer delta){
        productService.changeCost(productId, delta);
    }

}
