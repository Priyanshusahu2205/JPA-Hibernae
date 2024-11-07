package com.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	int stud_rollno;
	String stud_name;
	String stud_address;
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Student(int stud_rollno, String stud_name, String stud_address) {
		super();
		this.stud_rollno = stud_rollno;
		this.stud_name = stud_name;
		this.stud_address = stud_address;
	}


	public int getStud_rollno() {
		return stud_rollno;
	}
	public void setStud_rollno(int stud_rollno) {
		this.stud_rollno = stud_rollno;
	}
	public String getStud_name() {
		return stud_name;
	}
	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}
	public String getStud_address() {
		return stud_address;
	}
	public void setStud_address(String stud_address) {
		this.stud_address = stud_address;
	}
	
	
}
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

