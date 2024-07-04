package com.example.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name="PurchaseDetails")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int pillId;
	private int cId;
	private int pId;
	private int quantity;
	private double itemPrice;
	private double totalAmount;
	
	
	
}
