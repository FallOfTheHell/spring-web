package com.geekbrains.spring.web.controllers;

import com.geekbrains.spring.web.exeptions.ResourceNotFoundExceptions;
import com.geekbrains.spring.web.score.Product;
import com.geekbrains.spring.web.services.ProductService;
import dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


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
        return productService.find(maxPrice, minPrice, namePart, page).map(
                ProductDto::new
        );
    }

    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto){
        productDto.setId(null);
        productService.save(new Product(productDto.getId(), productDto.getTitle(),productDto.getCost()));
        return productDto;
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto){
        Product product = productService.findById(productDto.getId()).get();
        product.setTitle(productDto.getTitle());
        product.setCost(productDto.getCost());
        return productDto;
    }

    @GetMapping("/filter_cost")
    public List<Product> findProductByCostBetween(@RequestParam(defaultValue = "0") Integer min,@RequestParam(defaultValue = "3000") Integer max){
        return productService.findProductByCostBetween(min, max);
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        return new ProductDto(productService.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("Product not found: " + id)));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }


}
