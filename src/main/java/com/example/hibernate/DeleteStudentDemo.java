package com.example.hibernate;

import com.example.hibernateEntity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate1.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {

            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();
                System.out.println("Deleting student with id = 3");
                String string = "delete Student st where st.id=3";
                session.createMutationQuery(string).executeUpdate();
                session.getTransaction().commit();
            }
        }
    }
}
