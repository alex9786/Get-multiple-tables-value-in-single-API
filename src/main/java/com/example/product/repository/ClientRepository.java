package com.example.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
