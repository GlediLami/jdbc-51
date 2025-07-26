package org.sda.hibernate.relationships;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.sda.hibernate.user.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.openSession();

        List<User> allUsers = session.createQuery("VENDOS QUERYN TEND", User.class)
                .getResultList();

//        int departmentId = 1;
//
//        Department department = session.find(Department.class, departmentId);
//
//        List<Employee> employeesInIt = department.getEmployees();
//
//        for (Employee e : employeesInIt){
//            System.out.println("Name: " + e.getName() + ", ID: " + e.getId());
//        }


//        List<Employee> employees = session.createQuery("FROM Employee ep ORDER BY ep.name DESC", Employee.class).getResultList();
//        List<Employee> employees = session.createQuery("FROM Employee ep WHERE ep.department.name = 'IT'", Employee.class).getResultList();

//        List<Employee> employees = session.createQuery("FROM Employee ep ORDER BY ep.name DESC", Employee.class).getResultList();

//        List<Employee> employees = session
//                .createQuery("FROM Employee ep WHERE ep.department.id = :departmentId", Employee.class)
//                .setParameter("departmentId", 1)
//                .getResultList();

        Query<Long> employeesQuery = session
                .createQuery("SELECT COUNT(e) FROM Employee e", Long.class);
        Long count = employeesQuery.getSingleResult();
        System.out.println("ALL EMPLOYEES ARE: " + count);
//        List<Employee> employees = employeesQuery.getResultList();
//
//        for (Employee e : employees){
//            System.out.println(e.getName() + " ~ " + e.getDepartment().getName());
//        }









        session.close();
    }
}
