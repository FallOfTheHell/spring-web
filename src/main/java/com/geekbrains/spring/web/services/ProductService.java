package com.geekbrains.spring.web.services;

import com.geekbrains.spring.web.score.Product;
import com.geekbrains.spring.web.score.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void deleteById(Long id){
        productRepository.delProduct(id);
    }

    public void changeCost(Long productId, Integer delta) {
        Product product = productRepository.findById(productId);
        product.setCost(product.getCost() + delta);
    }
}
