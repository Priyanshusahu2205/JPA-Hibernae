package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyDemo {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		User user = new User();
		user.setUsername("Raaj");
		
		Task task1 = new Task();
		task1.setTitle("Development");
	    task1.setUser(user);
	    
	    Task task2 = new Task();
	    task2.setTitle("Testing");
	    task2.setUser(user);
	    
	    List<Task> tasks = new ArrayList<Task>();
	    tasks.add(task1); 
	    tasks.add(task2);
	    
	    user.setTasks(tasks);
	    
	    s.save(user);  s.save(task1); s.save(task2);
	    
	    t.commit();
	    s.close(); 
		
		
	}

}
