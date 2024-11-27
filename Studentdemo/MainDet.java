package com.lmsInterview21;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainDet {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate1.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Student stud = new Student();
		stud.setSid(101);
		stud.setSname("Raaj");
		stud.setSage(22);
		s.save(stud);
		t.commit();
		s.close();
		
	}

}
