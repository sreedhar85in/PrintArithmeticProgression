package com.datastructures.maths.arithmeticprogression.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
//@RequestMapping("/arithmeticprogression")
public class ArithmeticController {
	
	@ApiOperation(value = "Arithmetic progression API", notes = "API for Arithmetic Progression")
	@PostMapping("/sum")
	
	public String arithmeticController(HttpServletRequest request
			
			
			) {
		
		String token = request.getHeader("Authorization");
		System.out.println("Token is " + token);
		
		return "Sreedhar";
	}
	
	

}
