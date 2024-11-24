package com.EmpDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpDemo {
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Employee e = new Employee();
		e.setEid(101);
		e.setEname("Priyanshu");
		e.setEsalary(1500000000);
		s.save(e);
		
		t.commit();
		s.close();
		
	}

}
