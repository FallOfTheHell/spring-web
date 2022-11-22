package com.geekbrains.spring.web.jdbc;


import com.geekbrains.spring.web.client.Client;
import org.hibernate.Session;

import java.util.List;


public class ProductDaoImpl implements ProductDao {

    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public ProductHib findById(Long id) {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        ProductHib product = session.get(ProductHib.class, id);
        session.getTransaction().commit();
        return product;
    }

    @Override
    public List<ProductHib> findAll() {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        List<ProductHib> product = session.createQuery("select p from ProductHib p").getResultList();
        session.getTransaction().commit();
        return product;
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
//        session.createQuery("delete ProductHib where id = :index", ProductHib.class).
//                setParameter("index", id)
//                        .getSingleResult();
        ProductHib productHib = session.get(ProductHib.class, id);
        session.remove(productHib);
        session.getTransaction().commit();
    }

    @Override
    public ProductHib saveOrUpdate(ProductHib product) {
        System.out.println("===============");
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        System.out.println("===============");
        return product;
    }

    @Override
    public void buyClient(Long id) {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        ProductHib productHib = session.get(ProductHib.class, id);
        System.out.println(productHib);
        System.out.println(productHib.getClients());
        session.getTransaction().commit();
    }

}
