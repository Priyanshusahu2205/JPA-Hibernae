package com.demo;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Demo {
	
	public static void main(String[] args) {
	
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory sf = cfg.buildSessionFactory();
	Session s = sf.openSession();
	Transaction t = s.beginTransaction();
	
	Student stud1 = new Student();
	stud1.setSid(101);stud1.setSname("Raaj");stud1.setSage(22);stud1.setSaddress("Banglore");
	Student stud2 = new Student();
	stud2.setSid(102);stud2.setSname("Shipra");stud2.setSage(21);stud2.setSaddress("Hyderabad");
	Student stud3 = new Student();
	stud3.setSid(103);stud3.setSname("Priya");stud3.setSage(22);stud3.setSaddress("Mumbai");
	s.save(stud1);s.save(stud2);s.save(stud3);
	
	/*String hql = "from Student";
	Query q = s.createQuery(hql);
	List <Student> studlist = q.getResultList();
	for(Student st:studlist) {
		System.out.println(st.getSid());
		System.out.println(st.getSname());
		System.out.println(st.getSage());
		System.out.println(st.getSaddress());
		System.out.println();	
	}*/

	/*String hql = "from Student stud where stud.sid=:k";
	Query q = s.createQuery(hql);
	q.setParameter("k", 103);
	List <Student> studlist = q.getResultList();
	for(Student st:studlist) {
		System.out.println(st.getSid());
		System.out.println(st.getSname());
		System.out.println(st.getSage());
		System.out.println(st.getSaddress());
		System.out.println();	
	}*/
	
	/*String hql = "delete from Student stud where stud.sid=:i";
	Query q = s.createQuery(hql);
	q.setParameter("i", 103);
	int del = q.executeUpdate();
	System.out.println(del+"Record deleted.");*/
	
	/*String hql = "delete from Student";
	Query q = s.createQuery(hql);
	
	int del = q.executeUpdate();
	System.out.println(del+"Record deleted.");*/
	
	t.commit();
	s.close();
	}
}
