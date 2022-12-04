package com.geekbrains.spring.web.converters;

import com.geekbrains.spring.web.score.Product;
import dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public Product dtoToEntity(ProductDto p){
        return new Product(p.getId(), p.getTitle(), p.getCost());
    }

    public ProductDto entityToDto(Product p){
        return new ProductDto(p.getId(), p.getTitle(), p.getCost());
    }
}
