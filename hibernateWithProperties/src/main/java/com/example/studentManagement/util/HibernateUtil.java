package com.example.studentManagement.util;

import com.example.studentManagement.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory factory;

    static {
        try {
            Properties properties = new Properties();
            File propertiesFile = new File("src/main/resources/hibernate.properties");

            // Load properties from the hibernate.properties file
            properties.load(propertiesFile.toURI().toURL().openStream());

            // Configure the session factory using the properties
            factory = new Configuration()
                    .addProperties(properties) // Add properties directly
                    .addAnnotatedClass(Student.class) // Add your annotated classes
                    .buildSessionFactory();
        } catch (IOException e) {
            throw new ExceptionInInitializerError("Failed to load Hibernate properties: " + e.getMessage());
        }
    }

    public static SessionFactory getFactory() {
        return factory;
    }
}
