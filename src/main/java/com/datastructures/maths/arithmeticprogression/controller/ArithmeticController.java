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
import com.datastructures.maths.arithmeticprogression.model.AirthmeticSeriesResponse;
import com.datastructures.maths.arithmeticprogression.model.ArithmeticResponse;
import com.datastructures.maths.arithmeticprogression.model.ArithmeticprogRequest;
import com.datastructures.maths.arithmeticprogression.service.ArithmeticService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/arithmeticprogression")
public class ArithmeticController {

	@Autowired
	ArithmeticService arithmeticService;

	@ApiOperation(value = "Arithmetic progression API", notes = "API for Arithmetic Progression")
	@PostMapping("/sum")

	public ResponseEntity arithmeticController(HttpServletRequest request, @RequestBody ArithmeticprogRequest requestap

	) throws InternalException {

		String token = request.getHeader("Authorization");
		System.out.println("Token is " + token);

		ArithmeticResponse response = arithmeticService.sumofAP(requestap);

		return new ResponseEntity(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Arithmetic progression API", notes = "API for Arithmetic Progression")
	@PostMapping("/printseries")
	public ResponseEntity arithmeticController2(HttpServletRequest request, @RequestBody ArithmeticprogRequest requestap

	) throws InternalException {

		String token = request.getHeader("Authorization");
		System.out.println("Token is " + token);
		
		AirthmeticSeriesResponse response = arithmeticService.seriesPrint(requestap);

		return new ResponseEntity(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Arithmetic progression API", notes = "API for Arithmetic Progression")
	@PostMapping("/sum3")
	public String arithmeticController3(HttpServletRequest request

	) {

		String token = request.getHeader("Authorization");
		System.out.println("Token is " + token);

		return "Vibhu";
	}

	@ApiOperation(value = "Arithmetic progression API", notes = "API for Arithmetic Progression")
	@PostMapping("/random")
	public String arithmeticController4(HttpServletRequest request

	) {

		String token = request.getHeader("Authorization");
		System.out.println("Token is " + token);

		return "Robin";
	}

}
