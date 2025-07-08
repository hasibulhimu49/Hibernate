package com.hibernate.orm;

import com.hibernate.orm.entities.Student;
import com.hibernate.orm.utill.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("Hello World! This is Hibernate Class");
        
        // Create student object
        Student student = new Student();
        student.setName("Hasibul");
        student.setCollege("Km college");
        student.setAvtive(true);
        student.setPhone("01705064149");
        student.setAbout("This is more enough");
        student.setFatherName("Delowar Hossain");

        // Get session from HibernateUtil
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("Hibernate Session created successfully!");

        Transaction transaction = null;
        try {
            // Begin transaction
            transaction = session.beginTransaction();

            // Save the student object
            session.persist(student);

            // Commit the transaction
            transaction.commit();
            System.out.println("Student saved successfully!");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close session
            session.close();
        }
    }
}
