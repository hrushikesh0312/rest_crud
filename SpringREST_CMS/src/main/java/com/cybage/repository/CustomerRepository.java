package com.cybage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer getByName(String name);
}
