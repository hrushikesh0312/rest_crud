package com.cybage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.Address;
import com.cybage.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	public void addAddress(Address address) {
		addressRepository.save(address);
	}
	
	
}
