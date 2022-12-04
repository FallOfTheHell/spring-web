package com.geekbrains.spring.web.services;

import com.geekbrains.spring.web.exeptions.ResourceNotFoundExceptions;
import com.geekbrains.spring.web.score.Product;
import com.geekbrains.spring.web.score.ProductRepository;
import com.geekbrains.spring.web.services.specifications.ProductSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> find(Integer maxPrice, Integer minPrice, String partName, Integer page){
        Specification<Product> spec = Specification.where(null);
        if (maxPrice != null){
            spec = spec.and(ProductSpecifications.costGreaterOrEqualsThan(minPrice));
        }
        if (minPrice != null){
            spec = spec.and(ProductSpecifications.costLessThanOrEqualsThan(maxPrice));
        }
        if (partName != null){
            spec = spec.and(ProductSpecifications.nameLike(partName));
        }
        return productRepository.findAll(spec, PageRequest.of(page - 1, 5));
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    @Transactional
    public void changeCost(Long productId, Integer delta) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundExceptions("Product not found: " + productId));
        product.setCost(product.getCost() + delta);
    }

    public List<Product> findByCostBetween(Integer min, Integer max) {
        return productRepository.findAllByCostBetween(min,max);
    }

    public List<Product> findLowCostProduct(Integer min){
        return productRepository.findLowCostProduct(min);
    }

    public List<Product> findMaxCostProduct(Integer max){
        return productRepository.findMaxCostProduct(max);
    }

    public Product save(Product product){
       return productRepository.save(product);
    }

    public List<Product> findProductByCostBetween(Integer min, Integer max){
        return productRepository.findProductByCostBetween(min, max);
    }
}
