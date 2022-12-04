package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.converters.ProductConverter;
import com.geekbrains.spring.web.exeptions.ResourceNotFoundExceptions;
import com.geekbrains.spring.web.score.Product;
import com.geekbrains.spring.web.services.ProductService;
import dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductConverter productConverter;

    @GetMapping
    public Page<ProductDto> getAllProduct(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_price", required = false) Integer minPrice,
            @RequestParam(name = "max_price", required = false) Integer maxPrice,
            @RequestParam(name = "name_part", required = false) String namePart
    ){
        if (page < 1){
            page = 1;
        }
        return productService.findAll(minPrice, maxPrice , namePart, page).map(
                productConverter::entityToDto);
    }

    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto){
        Product product = productConverter.dtoToEntity(productDto);
        product = productService.save(product);
        return productConverter.entityToDto(product);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto){
        Product product = productService.update(productDto);
        return productConverter.entityToDto(product);
    }

    @GetMapping("/filter_cost")
    public List<Product> findProductByCostBetween(@RequestParam(defaultValue = "0") Integer min,@RequestParam(defaultValue = "3000") Integer max){
        return productService.findProductByCostBetween(min, max);
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("Product not found: " + id));
        return productConverter.entityToDto(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }


}
