package com.geekbrains.spring.web.score;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    List<Product> findAllByCostBetween(Integer min, Integer max);

    @Query("select p from Product p where p.cost < ?1")
    List<Product> findLowCostProduct(Integer max);

    @Query("select p from Product p where p.cost > ?1")
    List<Product> findMaxCostProduct(Integer min);

    List<Product> findProductByCostBetween(Integer min, Integer max);
}

