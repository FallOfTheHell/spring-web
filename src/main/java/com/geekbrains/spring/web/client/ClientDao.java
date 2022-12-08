package com.geekbrains.spring.web.client;

import com.geekbrains.spring.web.jdbc.ProductHib;

import java.util.List;

public interface ClientDao {
    Client findById(Long id);
    List<Client> findAll();
    void deleteById(Long id);
    Client saveOrUpdate(Client product);
    void buyProduct(Long id);
}
