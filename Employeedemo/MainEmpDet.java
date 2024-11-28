package com.lmsInterview22;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainEmpDet {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate2.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Employee e = new Employee();
		e.setEid(1001);
		e.setEname("Shipra");
		e.setEsalary(150000);
		
		s.save(e);
		t.commit();
		s.close();
		
	}

}
