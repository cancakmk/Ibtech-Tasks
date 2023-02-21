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
@Table(name = "account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AccountID")
	private int id;
	
	@Column(name = "Iban")
	private String iban;
	
	
	@Column(name = "Balance")
	private int balance;
	
	
	
	@ManyToOne
	@JoinColumn(name = "CustomerID")
	private Customer customer;
	
	@Column(name = "Currency")
	private String currencyType;
	

	public Account() {
		super();
	}

	public Account(String iban, String currencyType, int balance, Customer customer) {

		this.iban = iban;
		this.currencyType = currencyType;
		this.balance = balance;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "account [id=" + id + ", iban=" + iban + ", currencyType=" + currencyType + ", balance=" + balance
				+", customer=" + customer + "]";
	}
	
	

}
