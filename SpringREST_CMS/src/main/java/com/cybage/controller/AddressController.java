package com.cybage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.Address;
import com.cybage.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	AddressService addressService;

	@PostMapping("/addAddress")
	public String addAddress(@RequestBody Address address)
	{
	addressService.addAddress(address);
	return "address added successfully";
	}
	
}
