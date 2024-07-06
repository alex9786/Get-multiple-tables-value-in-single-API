package com.example.product.dto;

import lombok.Data;

@Data
public class ClientDto {

	private int id;
	private String name;
	public String emailId;
	public String password;
	private String contact;
}
