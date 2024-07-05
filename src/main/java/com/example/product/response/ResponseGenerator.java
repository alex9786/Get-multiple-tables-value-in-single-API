package com.example.product.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class ResponseGenerator {

	public ResponseEntity<Response> successResponse(Object object,HttpStatus httpStatus){	
		Response response = new Response();
		response.setData(object);
		response.setMessage("your process is success ");
		ResponseEntity<Response> responseEntity = new ResponseEntity<Response>(response,  httpStatus);
		return responseEntity;
	}
	
	public ResponseEntity<Response> errorresponse(Object object,HttpStatus httpStatus){
		Response response = new Response();
		response.setData(object);
		response.setMessage("your proces was faild");
		ResponseEntity<Response> responseEntity = new ResponseEntity<Response>(response,  httpStatus);
		return responseEntity;

		
	}
	
}
