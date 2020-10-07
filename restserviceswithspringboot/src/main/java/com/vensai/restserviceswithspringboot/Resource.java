package com.vensai.restserviceswithspringboot;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class Resource {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=2 , message = "Name Should Have 2 Characters")
	private String name;
	
	@Past
	private Date birthDate;
	
	
	public Resource() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	

}
