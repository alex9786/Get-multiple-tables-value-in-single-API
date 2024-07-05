package com.example.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="clentDetails")
@Builder
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="clientId")
	private int id;
	
	@Column(name="userName")
	private String name;

	@Column(name = "password")
	public String password;

	@Column(name = "emailId")
	public String emailId;
	
	@Column(name="contact")
	private String contact;


	
}
