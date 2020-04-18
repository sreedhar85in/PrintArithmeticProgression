package com.datastructures.maths.arithmeticprogression.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastructures.maths.arithmeticprogression.exception.InternalException;
import com.datastructures.maths.arithmeticprogression.model.ArithmeticResponse;
import com.datastructures.maths.arithmeticprogression.model.GeometricprogRequest;
import com.datastructures.maths.arithmeticprogression.service.GeometricService;

@RestController
@RequestMapping("/geometricprogression")
public class GeometricController {
	@Autowired
	GeometricService geometricService;
	
	public ResponseEntity geometricfindsum(HttpServletRequest request, @RequestBody GeometricprogRequest req) throws InternalException {
		String token = request.getHeader("Authorization");
		System.out.println("Token is " + token);

		return null;
	
		
		
		
	}

}
