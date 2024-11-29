package com.lmsInterview23i;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubjectS {
	
	@Id
	private int subid;
	private String subname;
	private int submarks;
	
	public SubjectS() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubjectS(int subid, String subname, int submarks) {
		super();
		this.subid = subid;
		this.subname = subname;
		this.submarks = submarks;
	}

	public int getSubid() {
		return subid;
	}

	public void setSubid(int subid) {
		this.subid = subid;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public int getSubmarks() {
		return submarks;
	}

	public void setSubmarks(int submarks) {
		this.submarks = submarks;
	}
	
	

}
