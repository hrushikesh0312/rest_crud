package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.Address;
import com.cybage.model.Customer;
import com.cybage.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public Customer getCustomer(int id) {
			
		Customer customer = customerRepository.findById(id).orElse(null);
        
//return customerRepository.getById(id);


	System.out.println(customer);
	return customer;
	}

	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		 customerRepository.deleteById(id);
		
		
	}

	public List<Customer> getAllCustomers() {
		List<Customer> customer = customerRepository.findAll();
		return customer;

	}

	public void updateCustomer(int id ,Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}

	public Customer getCustomerByName(String name) {
		Customer customer =customerRepository.getByName(name);
	return customer;
	}
	
}
