package com.ibtech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PhoneID")
	private int id;
	
	@Column(name = "Number")
	private String phoneNumber;
	
	@ManyToOne
	@JoinColumn(name = "CustomerID")
	private Customer customer;

	public Phone() {
		super();
	}

	public Phone(String phoneNumber, Customer customer) {

		this.phoneNumber = phoneNumber;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", phoneNumber=" + phoneNumber + ", customer=" + customer + "]";
	}

}
