package com.demo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DepartmentDetails {
	
public static void main(String[] args) {
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

        Department dep = new Department("Engineering");
        Employee emp1 = new Employee("Ayush", dep);
        Employee emp2 = new Employee("Bobby", dep);
        dep.setEmployees(List.of(emp1, emp2));

        s.save(dep);

        t.commit();

        displayDepartmentEmployeeCount(s);

        assignEmployeeToDepartment(s, 1, 2);

        s.close();
        sf.close();
    }

    public static void displayDepartmentEmployeeCount(Session session) {
        String hql = "SELECT d.name, COUNT(e.id) FROM Department d JOIN d.employees e GROUP BY d.id";
        Query query = session.createQuery(hql);
        List<Object[]> results = query.getResultList();

        for (Object[] row : results) {
            System.out.println("Department: " + row[0] + ", Employee Count: " + row[1]);
        }
    }

    public static void assignEmployeeToDepartment(Session session, int employeeId, int departmentId) {
        Transaction transaction = session.beginTransaction();

        Employee employee = session.get(Employee.class, employeeId);
        Department department = session.get(Department.class, departmentId);

        if (employee != null && department != null) {
            employee.setDepartment(department);
            session.update(employee);
            transaction.commit();
            System.out.println("Employee " + employee.getName() + " assigned to department " + department.getName());
        } else {
            System.out.println("Employee or Department not found.");
        }
    }

}
