package com.onck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onck.dao.CustomerDao;
import com.onck.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Transactional
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getCustomers();
	}

	@Transactional
	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		customerDao.saveCustomer(theCustomer);
	}

	@Transactional
	@Override
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		return customerDao.getCustomer(theId);
	}

	@Transactional
	@Override
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		customerDao.deleteCustomer(theId);
	}

}
