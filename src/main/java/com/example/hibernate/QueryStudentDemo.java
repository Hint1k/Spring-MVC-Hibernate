package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    private static void displayStudents(List<Student> students){
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        List<Student> students;

        try (SessionFactory factory = new Configuration()
                .configure("hibernate1.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {

            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();

                students = session.createQuery("from Student", Student.class).list();
                displayStudents(students);

                String string1 = "from Student st where st.lastName='Doe'";
                students = session.createQuery(string1, Student.class).list();
                displayStudents(students);

                String string2 = "from Student st where st.lastName ='Doe' or st.firstName ='Daffy'";
                students = session.createQuery(string2, Student.class).list();
                displayStudents(students);

                String string3 = "from Student st where st.email LIKE '%@test.com'";
                students = session.createQuery(string3, Student.class).list();
                displayStudents(students);

                session.getTransaction().commit();
            }
        }
    }
}
