package com.geekbrains.spring.web.jdbc;



public class MainHibernate {


    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
        sessionFactoryUtils.init();

//        === find_id ===
//        productDao.findById(1L);


        // ===DELETE====
//        productDao.deleteById(1L);
//        System.out.println(productDao.findAll());


//        === SaveOrUpdate ===
        productDao.saveOrUpdate(new ProductHib("Bread", 100));
        System.out.println(productDao.findAll());



        sessionFactoryUtils.shutdown();

    }
}
