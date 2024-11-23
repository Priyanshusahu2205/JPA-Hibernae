package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneDemo {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		Transaction t = s.beginTransaction();
		
		Student s1 = new Student();
		Subject s2 = new Subject();
		
		s1.setStudid(101); s1.setStudname("Rohan"); s1.setStudage(22); s1.setSub(s2);
		s.save(s1);
		
		s2.setSubid(1); s2.setSname("English"); s2.setSmarks(80);
		s.save(s2);
		
		
		t.commit();
		s.close();
	}

}

