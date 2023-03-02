package com.ibtech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "batchdata")
public class BatchData {
	
	@Id 
	@Column(name="SIRANO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int siraNo;
	
	@Column(name="STATUS") 
	private boolean status; //
	
	@Column(name="ACCOUNTNUMBER") 
	private int accountNo;
	
	@Column(name="AMOUNT") 
	private double amount;
	
	@Column(name="TRANSACTIONTYPE") 
	private char transactionType; 

	public BatchData(boolean status, int accountNo, double amount, char transactionType) {
		super();
		this.status = status;
		this.accountNo = accountNo;
		this.amount = amount;
		this.transactionType = transactionType;
	}

	public BatchData() {
		super();
	}

	public int getSiraNo() {
		return siraNo;
	}

	public void setSiraNo(int siraNo) {
		this.siraNo = siraNo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public char getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(char transactionType) {
		this.transactionType = transactionType;
	}
	
	

}