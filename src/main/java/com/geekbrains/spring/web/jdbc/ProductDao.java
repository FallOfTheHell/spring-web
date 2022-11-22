package com.geekbrains.spring.web.jdbc;



import java.util.List;

public interface ProductDao {
    ProductHib findById(Long id);
    List<ProductHib> findAll();
    void deleteById(Long id);
    ProductHib saveOrUpdate(ProductHib product);
    void buyClient(Long id);
}
