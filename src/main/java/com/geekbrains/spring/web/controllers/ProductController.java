package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.score.Product;
import com.geekbrains.spring.web.score.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public String getProduct(Model model){
        model.addAttribute("product", productRepository.getAllProducts());
        System.out.println(productRepository.getAllProducts());
        return "product_range";
    }

    @GetMapping("/{id}")
    public String showProductPage(Model model, @PathVariable Long id){
        Product product = productRepository.findById(id);
        model.addAttribute("product", product);
        System.out.println(product);
        return "product_info_page";
    }

}
