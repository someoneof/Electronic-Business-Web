package myshop.service;

import myshop.base.Dao;
import myshop.bean.Customer;

@SuppressWarnings("hiding")
public interface CustomerService<Customer> extends Dao<Customer>{

	boolean findByUsername(String username);

	Boolean login(String username, String password);
	
	Customer getCustomer(String username);

	void setCustomerState(String model,String username);

}
