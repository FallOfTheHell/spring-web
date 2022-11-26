package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.exeptions.ResourceNotFoundExceptions;
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
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("Product not found: " + id));
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }

    @GetMapping("/products/change_cost")
    public void changeCost(@RequestParam Long productId, @RequestParam Integer delta){
        productService.changeCost(productId, delta);
    }

    @GetMapping("/products/cost_between")
    public List<Product> changeCost(@RequestParam(defaultValue = "0") Integer min, @RequestParam(defaultValue = "200") Integer max){
        return productService.findByCostBetween(min, max);
    }

    @GetMapping("/products/min_cost")
    public List<Product> minCost(){
        return productService.findLowCostProduct();
    }

    @GetMapping("/products/max_cost")
    public List<Product> maxCost(){
        return productService.findMaxCostProduct();
    }

    @GetMapping("/products/agv_cost")
    public List<Product> averageCost(){
        return productService.findAverageCostProduct();
    }

}
