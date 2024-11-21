package com.demo;

import javax.persistence.Entity;

@Entity
class Bike extends Vehicle {
	
	private String bikename;

	public String getBikename() {
		return bikename;
	}

	public void setBikename(String bikename) {
		this.bikename = bikename;
	}

	

}
