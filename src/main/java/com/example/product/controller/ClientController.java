package com.example.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.enumeration.RequestType;
import com.example.product.dto.ClientDto;
import com.example.product.entity.Client;
import com.example.product.response.ResponseGenerator;
import com.example.product.service.ClientService;
import com.example.product.validation.ClientValidation;
import com.example.product.validation.ValidationResult;



@RestController
@RequestMapping("/api/Address")
@CrossOrigin(origins = "*",maxAge = 1800)

public class ClientController {

	
	@Autowired
	ClientService clientService;
	
	@Autowired
	ClientValidation clientValidation;
	
	@Autowired
	ResponseGenerator responseGenerator;

	@PostMapping("/post")
	public ResponseEntity<?> clientRegistration(@RequestBody ClientDto request) throws Exception {

		ValidationResult validationResult = clientValidation.validate(RequestType.POST, request);
		clientService.saveOrUpdate((Client) (validationResult.getObject()));

		try {
			return responseGenerator.successResponse(validationResult, HttpStatus.OK);
		} catch (Exception e) {
			return responseGenerator.errorresponse(validationResult, HttpStatus.BAD_REQUEST);
		}
	}
	
}
