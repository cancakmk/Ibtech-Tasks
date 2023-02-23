package com.ibtech.command.operation;

import java.util.List;

import com.ibtech.bag.Bag;
import com.ibtech.bag.BagKey;
import com.ibtech.dbo.CustomerDbo;
import com.ibtech.model.Customer;

public class CustomerOperation {
	
	private CustomerDbo customerDao;

	public CustomerOperation() {
		this.customerDao = new CustomerDbo();
	}

	
	
	
	
	public Bag add(Bag bag) {
		String name = (String) bag.getValue(BagKey.CNAME);
		String surname = (String) bag.getValue(BagKey.CSURNAME);

		Customer customer = new Customer(name, surname);
		Customer createdCustomer = customerDao.saveCustomer(customer);
		
		Bag createdCustomerBag = new Bag();
		createdCustomerBag.put(BagKey.CID, createdCustomer.getId());
		createdCustomerBag.put(BagKey.CNAME, createdCustomer.getName());
		createdCustomerBag.put(BagKey.CSURNAME, createdCustomer.getSurname());
		
		return createdCustomerBag;
	}
	
public void Update() {
	System.out.println("Update Çalıştı");
		
		
		
		
		
	}
public void Delete() {
	System.out.println("Delete Çalıştı");
	
	
	
	
	
}

}
