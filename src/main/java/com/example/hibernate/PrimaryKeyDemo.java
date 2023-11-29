package com.example.hibernate;

import com.example.hibernateEntity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
            Student student0 = new Student("John", "Doe", "john_doe@test.com");
            Student student1 = new Student("Jane", "Doe", "jane_doe@test.com");
            Student student2 = new Student("Donald", "Duck", "donald_duck@test.com");
            Student student3 = new Student("Debra", "Duck", "debra_duck@test.com");


        try (SessionFactory factory = new Configuration()
                .configure("hibernate1.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {

            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();
                System.out.println("Saving 4 students");
                session.persist(student0);
                session.persist(student1);
                session.persist(student2);
                session.persist(student3);

                session.getTransaction().commit();
                System.out.println("Done!");
            }
        }
    }
}
