package com.vensai.springdemo;

import org.springframework.stereotype.Component;

@Component
public class Laptop {
	
	private int lId;
	private String brand;
	
	public int getlId() {
		return lId;
	}
	public void setlId(int lId) {
		this.lId = lId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void brand() {
		System.out.println("display Laptop Brand...");
	}
	
}
