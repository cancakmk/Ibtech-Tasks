package com.ibtech;


import java.util.ArrayList;
import java.util.List;

import com.ibtech.dbo.AccountDbo;
import com.ibtech.dbo.AddressDbo;
import com.ibtech.dbo.CustomerDbo;
import com.ibtech.dbo.PhoneDbo;
import com.ibtech.model.Account;
import com.ibtech.model.Address;
import com.ibtech.model.Customer;
import com.ibtech.model.Phone;

public class App 
{
	public static void updateDatas(List<Customer> customerList, List<Account> accountList, List<Address> addressList, List<Phone> phoneList) {
    	CustomerDbo customerDao = new CustomerDbo();
    	AccountDbo accountDao = new AccountDbo();
    	AddressDbo addressDao = new AddressDbo();
    	PhoneDbo phoneDao = new PhoneDbo();	
    	
    	
    	
    	customerList.get(0).setName("Polat");
    	customerList.get(0).setSurname("Alemdar");
    	
    	accountList.get(0).setIban("TR003545");
    	
    	addressList.get(0).setCity("Mardin");
    	phoneList.get(0).setPhoneNumber("05684552535");
    	
    	
    	customerDao.updateCustomer(customerList.get(0));
    	accountDao.updateAccount(accountList.get(0));
    	addressDao.updateAddress(addressList.get(0));
    	phoneDao.updatePhone(phoneList.get(0));
	}
	public static void createDatas(List<Customer> customerList, List<Account> accountList, List<Address> addressList, List<Phone> phoneList) {
    	CustomerDbo customerDao = new CustomerDbo();
    	AccountDbo accountDao = new AccountDbo();
    	AddressDbo addressDao = new AddressDbo();
    	PhoneDbo phoneDao = new PhoneDbo();
    	
    	customerList.add(new Customer("Hakkıcan", "Çakmak"));
    	customerList.add(new Customer("Ali", "Çınar"));
    	

    	accountList.add(new Account("TR01", "USD", 35000, customerList.get(0)));
    	accountList.add(new Account("TR02", "TRY", 35100, customerList.get(0)));
    	accountList.add(new Account("TR11", "USD", 35114, customerList.get(1)));
    	accountList.add(new Account("TR12", "TRY", 35101, customerList.get(1)));

    	addressList.add(new Address("Turkey", "Kocaeli",customerList.get(0)));
    	addressList.add(new Address("Turkey", "Kocaeli",  customerList.get(1)));
    	
    	
    	phoneList.add(new Phone("05459719961",  customerList.get(0)));
    	phoneList.add(new Phone("05687952133",  customerList.get(1)));
    	
    	
    	customerList.forEach((n) -> customerDao.saveCustomer(n));
    	
    	accountList.forEach((n) -> accountDao.saveAccount(n));
    	
    	addressList.forEach((n) -> addressDao.saveAddress(n));
    	
    	phoneList.forEach((n) -> phoneDao.savePhone(n));		
    	
	}
	
	public static void getAllDatas(List<Customer> customerList, List<Account> accountList, List<Address> addressList, List<Phone> phoneList) {
    	CustomerDbo customerDao = new CustomerDbo();
    	AccountDbo accountDao = new AccountDbo();
    	AddressDbo addressDao = new AddressDbo();
    	PhoneDbo phoneDao = new PhoneDbo();
    	
    	System.out.println("Getting All Datas");
    	customerList.forEach((n) -> System.out.println(n));
    	System.out.println();
    	accountList.forEach((n) -> System.out.println(accountDao.getAccountById(n.getId())));
    	System.out.println();
    	addressList.forEach((n) -> System.out.println(addressDao.getAddressById(n.getId())));
    	System.out.println();
    	phoneList.forEach((n) -> System.out.println(phoneDao.getPhoneById(n.getId())));
    	
    	;
    	
    	
    	

	}
	
	public static void deleteAllDatas(List<Customer> customerList, List<Account> accountList, List<Address> addressList, List<Phone> phoneList) {
    	CustomerDbo customerDao = new CustomerDbo();
    	AccountDbo accountDao = new AccountDbo();
    	AddressDbo addressDao = new AddressDbo();
    	PhoneDbo phoneDao = new PhoneDbo();
    	
    	System.out.println();
    	accountList.forEach((n) -> accountDao.deleteAccount(n.getId()));
    	System.out.println();
    	addressList.forEach((n) -> addressDao.deleteAddress(n.getId()));
    	System.out.println();
    	phoneList.forEach((n) -> phoneDao.deletePhone(n.getId()));
    	System.out.println();
    	customerList.forEach((n) -> customerDao.deleteCustomer(n.getId()));
	}
    public static void main( String[] args )
    {
    	
    	CustomerDbo customerDao = new CustomerDbo();
    	AccountDbo accountDao = new AccountDbo();
    	AddressDbo addressDao = new AddressDbo();
    	PhoneDbo phoneDao = new PhoneDbo();
    	
    	List<Customer> customerList =customerDao.getAllCustomers() ;
    	List<Account> accountList = accountDao.getAllAccounts();
    	List<Address> addressList = addressDao.getAllAddresses();
    	List<Phone> phoneList = phoneDao.getAllPhones();
    	
    	//createDatas(customerList, accountList, addressList, phoneList);
    	//getAllDatas(customerList, accountList, addressList, phoneList);
    	//updateDatas(customerList, accountList, addressList, phoneList);
    	//deleteAllDatas(customerList, accountList, addressList, phoneList); 
    	

    }
}





