package com.example.hibernate;

import com.example.hibernateEntity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class CreateStudentDemo {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate1.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {

            try (Session session = factory.getCurrentSession()) {
                System.out.println("creating new student object");

                Student student = new Student("John", "Doe", "john_doe@test.com");
                session.beginTransaction();

                System.out.println("Saving the student");
                session.persist(student);

                session.getTransaction().commit();
                System.out.println("Done!");
            }
        }
    }
}
