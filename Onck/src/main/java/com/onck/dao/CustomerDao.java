package com.onck.dao;

import java.util.List;

import com.onck.entity.Customer;

public interface CustomerDao {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
}
