package com.example.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
