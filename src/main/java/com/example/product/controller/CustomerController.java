package com.example.product.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.dto.ProductDto;
import com.example.product.entity.Customer;
import com.example.product.entity.Product;
import com.example.product.entity.Purchase;
import com.example.product.service.CustomerService;

@RestController
@RequestMapping("/getDetail")
public class CustomerController {
	
	@Autowired
	CustomerService custumSservice;
	
	@PostMapping("/postClint")
	public Customer post(@RequestBody Customer customer) {
		return custumSservice.post(customer);
	}

	@PostMapping("/postProduct")
	public Product postProduct(@RequestBody Product product) {
		return custumSservice.postProduct(product);
	}
	
	@PostMapping("/postPurchase")
	public Purchase postPurchase(@RequestBody Purchase purchase) {
		return custumSservice.postPurchase(purchase);
	}
	
	@GetMapping("/get/{name}")
	public Optional<ProductDto> get(@PathVariable String name){
		return custumSservice.get(name);
	}

	
	
	
}
