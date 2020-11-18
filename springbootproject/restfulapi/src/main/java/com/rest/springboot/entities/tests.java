package com.rest.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class tests {
	
	public tests() {}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer number;
	
	private String name;
	
	public Integer getNumber() {
	  return number;
	  }
	
	public void setNumber(Integer number) {
	    this.number = number;
	  }
	  
	public String getName() {
		    return name;
	  }
	
	public void setName(String name) {
		    this.name = name;
	  }
}