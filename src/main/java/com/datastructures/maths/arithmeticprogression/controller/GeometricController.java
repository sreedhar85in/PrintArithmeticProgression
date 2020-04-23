package com.datastructures.maths.arithmeticprogression.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastructures.maths.arithmeticprogression.exception.InternalException;
import com.datastructures.maths.arithmeticprogression.model.ArithmeticResponse;
import com.datastructures.maths.arithmeticprogression.model.GeometricResponse;
import com.datastructures.maths.arithmeticprogression.model.GeometricSeriesRequest;
import com.datastructures.maths.arithmeticprogression.model.GeometricSumResponse;
import com.datastructures.maths.arithmeticprogression.model.GeometricprogRequest;
import com.datastructures.maths.arithmeticprogression.service.GeometricService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/geometricprogression")
public class GeometricController {
	@Autowired
	GeometricService geometricService;
	@ApiOperation(value = "Geometric Progression API", notes = "API to print Geometric progression series")
	@PostMapping("/printseries")	
	public ResponseEntity geometricprintseries(HttpServletRequest request, @RequestBody GeometricprogRequest req) throws InternalException {
		String token = request.getHeader("Authorization");
		System.out.println("Token is " + token);
		GeometricResponse response = geometricService.PrintSeries(req.getRatio(),req.getFirstNumber(),req.getNumberofSeries());
		return new ResponseEntity(response,HttpStatus.OK);
	
		
		
		
	}
	
	@ApiOperation(value = "Find sum of GP", notes = "find value of the sum of AP")
	@PostMapping("/sum")
	public ResponseEntity geometricfindsum(HttpServletRequest request, @RequestBody GeometricSeriesRequest req) throws InternalException{
		
		
		String token = request.getHeader("Authorization");
		System.out.println("Token is "+ token);
		GeometricSumResponse response = geometricService.sum(req.getRatio(), req.getFirstNumber(), req.getSeriesNumber());
		return new ResponseEntity(response,HttpStatus.OK);
		
	}

}
