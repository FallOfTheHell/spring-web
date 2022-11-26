package com.geekbrains.spring.web.score;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCostBetween(Integer min, Integer max);

    @Query("select min(p.cost) from Product p")
    List<Product> findLowCostProduct();

    @Query("select max(p.cost) from Product p")
    List<Product> findMaxCostProduct();

    @Query("select AVG(p.cost) from Product p")
    List<Product> findAverageCostProduct();

}

