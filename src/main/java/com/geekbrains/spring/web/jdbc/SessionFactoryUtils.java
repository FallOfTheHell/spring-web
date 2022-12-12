package com.geekbrains.spring.web.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class SessionFactoryUtils {
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public  void shutdown(){
        if (sessionFactory != null){
            sessionFactory.close();
        }
    }
    public  void init(){
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }
}
