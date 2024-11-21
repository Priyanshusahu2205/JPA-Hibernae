package com.demo;

import javax.persistence.Entity;

@Entity
class Car extends Vehicle {
	
	private String carname;

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	
	

}
