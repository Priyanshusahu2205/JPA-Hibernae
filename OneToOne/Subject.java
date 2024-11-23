package com.demo;

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
