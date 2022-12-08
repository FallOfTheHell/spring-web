package com.geekbrains.spring.web.repositories;

import com.geekbrains.spring.web.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    List<Product> findAllByCostBetween(Integer min, Integer max);

    @Query("select p from Product p where p.cost < ?1")
    List<Product> findLowCostProduct(Integer max);

    @Query("select p from Product p where p.cost > ?1")
    List<Product> findMaxCostProduct(Integer min);

}

