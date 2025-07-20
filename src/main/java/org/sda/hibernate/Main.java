package org.sda.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {

            Employee employee = new Employee(); // Create / populate Employee object
            employee.setName("Gledis");
            employee.setSalary(15);

            session.beginTransaction(); // Begin a database transaction

            session.persist(employee); // Save the entity in the database

            session.getTransaction().commit(); // Commit the transaction


            session = factory.openSession();

            session.beginTransaction();


            Employee dbEmployee = session.find(Employee.class, employee.getId());

            System.out.println("Database result: " + dbEmployee);

            session.getTransaction().commit();










        } catch (Exception e){
            System.out.println("EXCEPTION --> " + e.getMessage());
        } finally {
            factory.close();
        }

    }
}
