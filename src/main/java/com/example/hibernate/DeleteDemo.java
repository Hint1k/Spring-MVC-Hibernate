package com.example.hibernate;

import com.example.hibernateEntity.Instructor;
import com.example.hibernateEntity.InstructorDetail;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()) {

            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();
                int id = 7;
                System.out.println("Deleting instructor with id = " + id);
                Instructor instructor = session.get(Instructor.class, id);
                session.remove(instructor);
                session.getTransaction().commit();
            }
        }
    }
}
