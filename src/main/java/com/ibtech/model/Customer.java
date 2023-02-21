package com.ibtech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CID")
	private int id;
	
	@Column(name = "CName")
	private String name;
	@Column(name = "CSurname")
	private String surname;
	
	public Customer() {
		super();
	}

	public Customer(String name, String surname) {
		this.name = name;
		this.surname = surname;
		
	}

	public int getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}


	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", surname=" + surname +"]";
	}
	
	
	

}
