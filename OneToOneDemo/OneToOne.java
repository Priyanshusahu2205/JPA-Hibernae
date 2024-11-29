package com.lmsInterview23i;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOne {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate3.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		
		Transaction t = s.beginTransaction();
		
		Student s1 = new Student();
		SubjectS s2 = new SubjectS();
		
		s1.setStudid(101); s1.setStudname("Raaj"); s1.setStudaddress("Mumbai"); s1.setSub(s2);
		s.save(s1);
		
		s2.setSubid(001); s2.setSubname("English"); s2.setSubmarks(80);
		s.save(s2);
		
		t.commit();
		s.close();
	}
	
	
}
