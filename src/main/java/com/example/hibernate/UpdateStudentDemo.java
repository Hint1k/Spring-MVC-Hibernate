package com.example.hibernate;

import com.example.hibernateEntity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate1.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {

            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();
                int studentId = 1;
                System.out.println("Student with id = " + studentId);
                Student student = session.get(Student.class, studentId);
                System.out.println("Updating student name to Mary");
                student.setFirstName("Mary");
                session.getTransaction().commit();
            }

            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();
                System.out.println("Updating email address for all students");
                String string = "update Student set email='test@demo2.com'";
                session.createMutationQuery(string).executeUpdate();
                session.getTransaction().commit();
            }
        }
    }
}
