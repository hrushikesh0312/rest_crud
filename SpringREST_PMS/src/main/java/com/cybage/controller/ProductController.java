package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.exception.RecordNotFoundException;
import com.cybage.model.Product;
import com.cybage.service.ProductService;


@RestController
@CrossOrigin(origins="http://localhost:4200") // angular appln url
//@CrossOrigin(origins="*")// for all requests
public class ProductController {
	
	@Autowired
	ProductService productService;


	@PostMapping("/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody Product product){
		
		productService.addProduct(product);
		return new ResponseEntity<String>("product added successfully",HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public  ResponseEntity<Product> deleteBook(@PathVariable int id) {
		
		Product product = productService.getProduct(id);
		
		// here we are calling get before deleting to get the product deleted as output 
		productService.deleteProduct(id);
		
		return new ResponseEntity<Product>(product,HttpStatus.OK);

		
	}
	
	@GetMapping("/getProduct/{id}")
	public  ResponseEntity<Product> getProduct(@PathVariable("id") int id)
	{
		Product product = productService.getProduct(id);
		if(product==null)
			throw new RecordNotFoundException("product not found");
		
		return new ResponseEntity<Product>(product,HttpStatus.FOUND);

	}
	
	@GetMapping("/getAllProducts")
	public  ResponseEntity<List<Product>> getAllProducts()
	{
		List<Product> products = productService.getAllProducts();
		
		return new ResponseEntity<List<Product>>(products,HttpStatus.FOUND);

	}
	

			@PutMapping("/updateProduct/{id}")
			public ResponseEntity<String> updateProduct(@PathVariable int id , @RequestBody Product product) 
			{
				productService.updateProduct(id,product);
				return new ResponseEntity<String>("product update  successfull",HttpStatus.OK);

				
				
			}
			
			
//			@ExceptionHandler(RecordNotFoundException.class)
//			public ResponseEntity<String> handleException(RecordNotFoundException exception){
//				return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
//			}
			// this is mapper to the exception i.e when exception is thrown it comes here 
			// if we have 20 controllers and each throwing some exception then we need to write this method in each controller class this increases code redudancy so we write
			// a golbal exception handler class in exception package which will map all the exception thrown by the controller and reduce code redudancy see exception class globalException
}
