package com.example.hibernate;

import com.example.hibernateEntity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {

        Student newStudent = new Student("Daffy", "Smith", "daffy_smith@test.com");

        try (SessionFactory factory = new Configuration()
                .configure("hibernate1.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {

            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();
                session.persist(newStudent);
                session.getTransaction().commit();
            }

            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();

                System.out.println("Reading student with id: " + newStudent.getId());
                Student student = session.get(Student.class, newStudent.getId());
                System.out.println("Complete:" + student);

                session.getTransaction().commit();
            }
        }
    }
}
