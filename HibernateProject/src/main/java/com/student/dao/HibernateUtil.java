package com.student.dao;

import com.student.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
    }
}
