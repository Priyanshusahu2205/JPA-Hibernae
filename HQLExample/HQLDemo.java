package com.lmsInterview24i;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQLDemo {
	
public static void main(String[] args) {
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate5.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        //insert operation
        insertEmployee(session);

        //update operation
        updateEmployee(session);

        //delete operation
        deleteEmployee(session);

        //retrieve operation
        retrieveEmployees(session);

        session.close();
        sf.close();
    }

    private static void insertEmployee(Session session) {
        Transaction tx = session.beginTransaction();
        Employee emp1 = new Employee(1, "Raaj", "IT", 75000000);
        Employee emp2 = new Employee(2, "Shipra", "Finance", 800000);
        session.save(emp1);
        session.save(emp2);
        tx.commit();
        System.out.println("Employees inserted successfully.");
    }

    private static void updateEmployee(Session session) {
        Transaction tx = session.beginTransaction();
        String hql = "UPDATE Employee SET empSalary = :salary WHERE empName = :name";
        Query<?> query = session.createQuery(hql);
        query.setParameter("salary", 85000000.0);
        query.setParameter("name", "Raaj");
        int result = query.executeUpdate();
        tx.commit();
        System.out.println("Employee salary updated for Alice. Rows affected: " + result);
    }

    private static void deleteEmployee(Session session) {
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM Employee WHERE empName = :name";
        Query<?> query = session.createQuery(hql);
        query.setParameter("name", "Shipra");
        int result = query.executeUpdate();
        tx.commit();
        System.out.println("Employee record deleted for Bob. Rows affected: " + result);
    }

    private static void retrieveEmployees(Session session) {
        String hql = "FROM Employee";
        Query<Employee> query = session.createQuery(hql, Employee.class);
        List<Employee> employees = query.list();
        System.out.println("List of Employees:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

}
