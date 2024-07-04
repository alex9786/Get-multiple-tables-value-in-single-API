package com.example.product.service;

import java.util.Optional;

import com.example.product.dto.ProductDto;
import com.example.product.entity.Customer;
import com.example.product.entity.Product;
import com.example.product.entity.Purchase;

public interface CustomerService {

	Customer post(Customer customer);

	Product postProduct(Product product);

	Purchase postPurchase(Purchase purchase);

	Optional<ProductDto> get(String name);

	
}
