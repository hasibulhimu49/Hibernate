package com.hibernate.orm.utill;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            if (sessionFactory == null) {
                sessionFactory = new Configuration()
                        .configure("hibernate.cfg.xml") // Make sure this file is in src/main/resources
                        .buildSessionFactory();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error in creating SessionFactory: " + e.getMessage());
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
