package com.geekbrains.spring.web.jdbc;


import com.geekbrains.spring.web.client.ClientDao;
import com.geekbrains.spring.web.client.ClientDaoImpl;

public class MainHibernate {


    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
        ClientDao clientDao = new ClientDaoImpl(sessionFactoryUtils);
        sessionFactoryUtils.init();

//        === find_id ===
//        productDao.findById(1L);

        // ===DELETE====
//        productDao.deleteById(1L);
//        System.out.println(productDao.findAll());


//        === SaveOrUpdate ===
//        productDao.saveOrUpdate(new ProductHib("Bread", 2000));
//        System.out.println(productDao.findAll());

//        System.out.println(clientDao.findById(1L));
//        System.out.println(clientDao.findAll());

        productDao.buyClient(1L);



        sessionFactoryUtils.shutdown();

    }
}
