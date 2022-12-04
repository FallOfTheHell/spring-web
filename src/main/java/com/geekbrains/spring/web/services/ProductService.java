package com.geekbrains.spring.web.services;

import com.geekbrains.spring.web.exeptions.ResourceNotFoundExceptions;
import com.geekbrains.spring.web.score.Product;
import com.geekbrains.spring.web.score.ProductRepository;
import com.geekbrains.spring.web.services.specifications.ProductSpecifications;
import dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public Page<Product> findAll(Integer maxPrice, Integer minPrice, String partName, Integer page){
        Specification<Product> spec = Specification.where(null);
        if (minPrice != null){
            spec = spec.and(ProductSpecifications.costGreaterOrEqualsThan(minPrice));
        }
        if (maxPrice != null){
            spec = spec.and(ProductSpecifications.costLessThanOrEqualsThan(maxPrice));
        }
        if (partName != null){
            spec = spec.and(ProductSpecifications.nameLike(partName));
        }
        return productRepository.findAll(spec, PageRequest.of(page - 1, 5));
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }


    public Product save(Product product){
       return productRepository.save(product);
    }

    public List<Product> findProductByCostBetween(Integer min, Integer max){
        return productRepository.findProductByCostBetween(min, max);
    }

    @Transactional
    public Product update(ProductDto productDto) {
        Product product = productRepository.findById(productDto.getId()).orElseThrow(
                () -> new ResourceNotFoundExceptions("Невозможно объявить продукт, не найден в базе: " + productDto.getId()));
        product.setTitle(productDto.getTitle());
        product.setCost(product.getCost());
        return product;
    }
}
