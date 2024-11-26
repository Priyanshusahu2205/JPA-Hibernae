package com.bookdetails;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BookDetails {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate6.cfg.xml");
		
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        
        Book b = new Book();
        b.setId(1011);
        b.setTitle("Believe In Yourself");
        b.setAuthor("Dr Joseph Murphy");
        s.save(b);
        
        t.commit();
        s.close();
	}

}
