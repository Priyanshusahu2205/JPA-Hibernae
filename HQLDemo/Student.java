package com.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	private int sid;
	private String sname;
	private int sage;
	private String saddress;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int sid, String sname, int sage, String saddress) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		this.saddress = saddress;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	
	

}
