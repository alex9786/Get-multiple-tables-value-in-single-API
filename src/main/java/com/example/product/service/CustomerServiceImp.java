package com.example.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.dto.ProductDto;
import com.example.product.entity.Customer;
import com.example.product.entity.Product;
import com.example.product.entity.Purchase;
import com.example.product.repository.CustomerRepository;
import com.example.product.repository.ProductRepository;
import com.example.product.repository.PurchaseRepository;

@Service
public class CustomerServiceImp implements  CustomerService{

	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	PurchaseRepository purcheseRepo;
	
	
	@Override
	public Customer post(Customer customer) {
		return customerRepo.save(customer) ;
	}

	@Override
	public Product postProduct(Product product) {
	    return productRepo.save(product);
	}

	@Override
	public Purchase postPurchase(Purchase purchase) {
		
		Purchase obj = new Purchase();
		obj.setPillId(purchase.getPillId());
		obj.setCId(purchase.getCId());
		obj.setPId(purchase.getPId());
		obj.setItemPrice(purchase.getItemPrice());
		obj.setQuantity(purchase.getQuantity());
		obj.setTotalAmount(purchase.getItemPrice()*purchase.getQuantity());
		return purcheseRepo.save(obj);
	}

	@Override
	public Optional<ProductDto> get(String name) {
		return purcheseRepo.findByName(name);
	}


}
