package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FirstDemo {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Student stud = new Student();
		stud.setStud_rollno(1001);
		stud.setStud_name("Raaj");
		stud.setStud_address("Banglore");
		s.save(stud);
		t.commit();
		s.close();
	}

}
