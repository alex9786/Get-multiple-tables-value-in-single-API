package com.example.product.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.ControllerAdvice.ObjectInvalidException;
import com.example.product.dto.ClientDto;
import com.example.product.entity.Client;
import com.example.product.enumeration.RequestType;
import com.example.product.service.ClientService;
import com.example.product.util.ValidationUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Service
@AllArgsConstructor(onConstructor_ = { @Autowired })

public class ClientValidation {

	
	@Autowired
	ClientService clientService;
	
	List<String> errors = null;
	List<String> errorsObj = null;
	Optional<Subject> subject = null;
	
    public ValidationResult validate(RequestType requestType, ClientDto request) {
    	
        List<String> errors = new ArrayList<>();
        ValidationResult result = new ValidationResult();
		Client user = null;

		if (requestType.equals(RequestType.POST)) {
			if (ValidationUtil.isNull(request.getId())) {
				throw new ObjectInvalidException("invalid.request.payload");
			}

			if (ValidationUtil.isNullOrEmpty(request.getName())) {
				errors.add("userName.required");
			} else {
				
				request.setEmailId(ValidationUtil.getFormattedString(request.getEmailId()));
				if (!ValidationUtil.isValidEmailId(request.getEmailId())) {
					errors.add("user.email.invalid");
				}
				
				request.setContact(ValidationUtil.getFormattedString(request.getContact()));
				if(!ValidationUtil.isValidContact(request.getContact())) {
					errors.add("this is invalid contact ");
				}
			   
				request.setName(ValidationUtil.getFormattedString(request.getName()));
				if(!ValidationUtil.isValidName(request.getName())) {
					errors.add(" this is invalid name");
				}
		}
     }
		
//		if (ValidationUtil.isNullOrEmpty(request.getEmailId())) {
//			throw new ObjectInvalidException("emailId required");
//		}
//		if (ValidationUtil.isNullOrEmpty(request.getPassword())) {
//			throw new ObjectInvalidException("Password required");
//		}
//		if (ValidationUtil.isNullOrEmpty(request.getContact())) {
//			throw new ObjectInvalidException(" contact required");
//		}

		if (errors.size() > 0) {
			String errorMessage = errors.stream().map(a -> String.valueOf(a)).collect(Collectors.joining(", "));
			throw new ObjectInvalidException(errorMessage);
		}

		    if(null== user) {
		    	user=Client.builder().name(request.getName()).emailId(request.getEmailId())
		    		.password(request.getPassword()).contact(request.getContact()).build();
		    }else {
		    	user.setName(request.getName());
		    	user.setEmailId(request.getEmailId());
		    	user.setPassword(request.getPassword());
		    	user.setContact(request.getContact());
		    }
        result.setObject(user);
        return result;
    }
    
    }
    

