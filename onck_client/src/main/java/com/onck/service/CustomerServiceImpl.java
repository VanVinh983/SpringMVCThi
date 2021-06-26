package com.onck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.onck.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	private RestTemplate restTemplate;
	private String crmRestUrl;

	@Autowired
	public CustomerServiceImpl(RestTemplate theRestTemplate, @Value("${crm.rest.url}") String url) {
		restTemplate = theRestTemplate;
		crmRestUrl = url;
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Customer>>() {
				});
		List<Customer> customers=responseEntity.getBody();
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		int id=theCustomer.getId();
		if(id==0) {
			restTemplate.postForEntity(crmRestUrl, theCustomer, Customer.class);
		}else {
			restTemplate.put(crmRestUrl, theCustomer);
		}

	}

	@Override
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		Customer customer=restTemplate.getForObject(crmRestUrl+"/"+theId,Customer.class);
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		restTemplate.delete(crmRestUrl+"/"+theId);

	}

}
