package com.cybage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cybage.model.Product;
import com.cybage.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	public Product getProduct(int id) {
			
		Product product = productRepository.findById(id).orElse(null);
        
//return productRepository.getById(id);


	System.out.println(product);
	return product;
	}

	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		 productRepository.deleteById(id);
		
		
	}

	public List<Product> getAllProducts() {
		List<Product> product = productRepository.findAll();
		return product;

	}

	public void updateProduct(int id ,Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}
}
