package com.geekbrains.spring.web.jdbc;


import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
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
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        return product;
    }
}
