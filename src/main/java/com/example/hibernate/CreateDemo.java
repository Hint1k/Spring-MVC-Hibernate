package com.example.hibernate;

import com.example.hibernateEntity.Instructor;
import com.example.hibernateEntity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        Instructor instructor = new Instructor(
                "John","Doe","jd@test.com");
        InstructorDetail instructorDetail = new InstructorDetail(
                "JDChannel","surfing");

        instructor.setInstructorDetail(instructorDetail);

        try (SessionFactory factory = new Configuration()
                .configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()) {

            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();
                session.persist(instructor);
                session.getTransaction().commit();
            }
        }
    }
}
