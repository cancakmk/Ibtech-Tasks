package com.ibtech.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "specialaccounts")
public class SpecialAccount {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID") 
	private int id;
	
	@Column(name="ACCOUNTNAME") 
	private String accountName;
	
	@Column(name="BALANCE") 
	private double balance;

	public SpecialAccount() {
		super();
	}

	public SpecialAccount(String accountName, double balance) {
		super();
		this.accountName = accountName;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}