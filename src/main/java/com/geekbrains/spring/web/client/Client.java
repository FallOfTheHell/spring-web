package com.geekbrains.spring.web.client;


import com.geekbrains.spring.web.jdbc.ProductHib;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "products_clients",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductHib> productHib;

    public Client() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public List<ProductHib> getProductHib() {
        return productHib;
    }

    public void setProductHib(List<ProductHib> productHib) {
        this.productHib = productHib;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Client [id = %d, name = %s]", ID, name);
    }

}
