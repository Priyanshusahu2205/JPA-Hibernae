package com.demo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity

public class Student {
	@Id
	private int studid;
	private String studname;
	private int studage;
	@OneToOne(cascade=CascadeType.PERSIST)
	private Subject sub;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int studid, String studname, int studage, Subject sub) {
		super();
		this.studid = studid;
		this.studname = studname;
		this.studage = studage;
		this.sub = sub;
	}

	public int getStudid() {
		return studid;
	}

	public void setStudid(int studid) {
		this.studid = studid;
	}

	public String getStudname() {
		return studname;
	}

	public void setStudname(String studname) {
		this.studname = studname;
	}

	public int getStudage() {
		return studage;
	}

	public void setStudage(int studage) {
		this.studage = studage;
	}

	public Subject getSub() {
		return sub;
	}

	public void setSub(Subject sub) {
		this.sub = sub;
	}
	
	

}


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject {
	@Id
	private int subid;
	private String sname;
	private int smarks;
	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Subject(int subid, String sname, int smarks) {
		super();
		this.subid = subid;
		this.sname = sname;
		this.smarks = smarks;
	}
	
	public int getSubid() {
		return subid;
	}
	public void setSubid(int subid) {
		this.subid = subid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSmarks() {
		return smarks;
	}
	public void setSmarks(int smarks) {
		this.smarks = smarks;
	}
	
	

}
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
