package com.lmsInterview23ii;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectid;
    private String projectname;
    private double budget;
    
    @ManyToOne
	@JoinColumn(name="employee_eid")
    private Employee employee;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int projectid, String projectname, double budget, Employee employee) {
		super();
		this.projectid = projectid;
		this.projectname = projectname;
		this.budget = budget;
		this.employee = employee;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
    
    

}
