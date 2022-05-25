package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.exception.RecordNotFoundException;
import com.cybage.model.Customer;
import com.cybage.service.CustomerService;


@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;


	@PostMapping("/addCustomer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
		
		customerService.addCustomer(customer);
		return new ResponseEntity<String>("customer added successfully",HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public  ResponseEntity<Customer> deleteBook(@PathVariable int id) {
		
		Customer customer = customerService.getCustomer(id);
		
		// here we are calling get before deleting to get the customer deleted as output 
		customerService.deleteCustomer(id);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);

		
	}
	
	@GetMapping("/getCustomer/{id}")
	public  ResponseEntity<Customer> getCustomer(@PathVariable("id") int id)
	{
		Customer customer = customerService.getCustomer(id);
		if(customer==null)
			throw new RecordNotFoundException("customer not found");
		
		return new ResponseEntity<Customer>(customer,HttpStatus.FOUND);

	}
	
	@GetMapping("/getAllCustomers")
	public  ResponseEntity<List<Customer>> getAllCustomers()
	{
		List<Customer> customers = customerService.getAllCustomers();
		
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.FOUND);

	}
	

			@PutMapping("/updateCustomer/{id}")
			public ResponseEntity<String> updateCustomer(@PathVariable int id , @RequestBody Customer customer) 
			{
				customerService.updateCustomer(id,customer);
				return new ResponseEntity<String>("customer update  successfull",HttpStatus.OK);

				
				
			}
			
			@GetMapping("/getCustomerByName/{name}")
			public  ResponseEntity<Customer> getCustomer(@PathVariable("name") String name)
			{
				Customer customer = customerService.getCustomerByName(name);
				if(customer==null)
					throw new RecordNotFoundException("customer not found");
				
				return new ResponseEntity<Customer>(customer,HttpStatus.FOUND);

			}
}
