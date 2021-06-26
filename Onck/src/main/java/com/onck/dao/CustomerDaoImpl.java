package com.onck.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onck.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		List<Customer> customers=session.createNativeQuery("select * from customer",Customer.class).getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Customer customer=session.get(Customer.class, theId);
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Customer customer=session.get(Customer.class, theId);
		session.delete(customer);
	}
	
}
