package com.geekbrains.spring.web.jdbc;



import com.geekbrains.spring.web.client.Client;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductHib {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private Integer cost;

    @ManyToMany
    @JoinTable(
            name = "products_clients",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private List<Client> clients;

    public ProductHib(String title, Integer cost) {
        this.title = title;
        this.cost = cost;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public ProductHib() {
    }

    @Override
    public String toString() {
        return String.format("id = %-2s | title = %-15s | cost = %-8s" , id, title, cost);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}

