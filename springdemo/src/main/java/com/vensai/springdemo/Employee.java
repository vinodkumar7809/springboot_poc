package com.vensai.springdemo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private int id;
	private String empName;
	private String tech;
	
	public Employee() {
	}

	public Employee(int id, String empName) {
		super();
		this.id = id;
		this.empName = empName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getTech() {
		return tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", tech=" + tech + "]";
	}
	
}
