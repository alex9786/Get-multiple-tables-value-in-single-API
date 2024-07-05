package com.example.product.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.security.auth.Subject;

import org.springframework.stereotype.Service;

import com.example.product.ControllerAdvice.ObjectInvalidException;
import com.example.product.entity.Client;

import com.example.product.util.ValidationUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Service
@AllArgsConstructor
@NoArgsConstructor
public class ClientValidation {

	List<String> errors = null;
	List<String> errorsObj = null;
	Optional<Subject> subject = null;
	
	@SuppressWarnings({ "null", "unused" })
	public ValidationResult validate(Client client) {
		
		errors = new ArrayList<>();
		ValidationResult result = new ValidationResult();
		Client entity = null;
		
		if(ValidationUtil.isNullOrEmpty(client.getEmailId())) {
			throw new ObjectInvalidException("email required");
		}
		if(ValidationUtil.isNullOrEmpty(client.getName())) {
		    throw new ObjectInvalidException("name required");
		}
		if(ValidationUtil.isNullOrEmpty(client.getContact())) {
			throw new ObjectInvalidException("contact required");
		}
		if(errors.size()>0) {
			String errorMessage = errors.stream().map(a-> String.valueOf(a)).collect(Collectors.joining(" ,"));
			throw new ObjectInvalidException(errorMessage);
		}
		if(null == client) {
			client = Client.builder().name(client.getName())
					.emailId(client.getEmailId()).password(client.getPassword())
					.contact(client.getContact()).build();
		}else {
			entity.setName(client.getName());
			entity.setEmailId(client.getEmailId());
			entity.setPassword(client.getPassword());
			entity.setContact(client.getContact());
		}
		
		result.setObject(entity);
		return result;
	}

}
