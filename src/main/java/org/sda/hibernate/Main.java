package org.sda.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {

            Employee employee = new Employee(); // Create / populate Employee object
            employee.setName("GLEDIS");
            employee.setSalary(150);

            Employee employee2 = new Employee(); // Create / populate Employee object
            employee2.setName("TEST");
            employee2.setSalary(1500);

            session.beginTransaction(); // Begin a database transaction

            session.persist(employee); // Save the entity in the database
            session.persist(employee2);

            session.getTransaction().commit(); // Commit the transaction


            session = factory.openSession();

            session.beginTransaction();


            List<Employee> dbEmployee = session.createQuery("FROM Employee").getResultList();

            System.out.println("Database result: " + dbEmployee);

            for (Employee emp : dbEmployee){
                System.out.println(emp);
            }

            session.getTransaction().commit();

















        } catch (Exception e){
            System.out.println("EXCEPTION --> " + e.getMessage());
        } finally {
            factory.close();
        }

    }
}
