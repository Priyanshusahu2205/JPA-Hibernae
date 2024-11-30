package com.lmsInterview23ii;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToMany {
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate4.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Employee emp = new Employee();
        emp.setEid(101);
        emp.setEname("Raaj");
        emp.setEage(22);
        
        Project prj1 = new Project();
        prj1.setProjectid(001);
        prj1.setProjectname("Project Semi");
        prj1.setBudget(100000000);
        prj1.setEmployee(emp);
        
        Project prj2 = new Project();
        prj2.setProjectid(002);
        prj2.setProjectname("Project Cart");
        prj2.setBudget(20000000);
        prj2.setEmployee(emp);
        
        List<Project> projects = new ArrayList<Project>();
	    projects.add(prj1); 
	    projects.add(prj2);
	    emp.setProjects(projects);
	    
	    s.save(emp);  s.save(prj1); s.save(prj2);
	    
	    t.commit();
	    s.close();
	    
	    System.out.println("Employee and Projects saved successfully!");
		
	}

}
