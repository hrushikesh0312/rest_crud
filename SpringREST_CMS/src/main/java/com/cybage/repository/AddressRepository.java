package com.cybage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
