package com.geekbrains.spring.web.client;

import com.geekbrains.spring.web.jdbc.ProductHib;
import com.geekbrains.spring.web.jdbc.SessionFactoryUtils;
import org.hibernate.Session;

import java.util.List;

public class ClientDaoImpl implements ClientDao{

    private SessionFactoryUtils sessionFactoryUtils;

    public ClientDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Client findById(Long id) {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        Client client = session.get(Client.class, id);
        session.getTransaction().commit();
        return client;
    }

    @Override
    public List<Client> findAll() {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        List<Client> client = session.createQuery("select c from Client c").getResultList();
        session.getTransaction().commit();
        return client;
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        Client client = session.get(Client.class, id);
        session.remove(client);
        session.getTransaction().commit();
    }

    @Override
    public Client saveOrUpdate(Client client) {
        Session session = sessionFactoryUtils.getSession();
        System.out.println("===============");
        session.beginTransaction();
        session.saveOrUpdate(client);
        session.getTransaction().commit();
        System.out.println("===============");
        return client;
    }

    @Override
    public void buyProduct(Long id) {
        Session session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        Client client = session.get(Client.class, id);
        System.out.println(client);
        System.out.println(client.getProductHib());
        session.getTransaction().commit();
    }
}
