package com.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class MainDemo {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Vehicle v = new Vehicle();
		v.setId(1001);
		
		Car c = new Car();
		c.setCarname("BMW");
		
		Bike b = new Bike();
		b.setBikename("Continentalgt");
		
		s.save(v);
		s.save(c);
		s.save(b);
		
		String hql = "FROM Vehicle";
		Query query = s.createQuery(hql);
		List<Vehicle> vehicles = query.list();
		
		for(Vehicle vehicle:vehicles)
		{
			System.out.println("Vehicle ID : "+vehicle.getId());
		}
		
		
		t.commit();
		s.close();
		
	}

}
