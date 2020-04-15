package com.datastructures.maths.arithmeticprogression.service;

import org.springframework.stereotype.Service;

import com.datastructures.maths.arithmeticprogression.model.ArithmeticResponse;
import com.datastructures.maths.arithmeticprogression.model.ArithmeticprogRequest;

@Service
public class ArithmeticService {
	
	
	public ArithmeticResponse sumofAP(ArithmeticprogRequest requestap) {
		
		float firstdigit = requestap.getFirstNumber();
		float diff = requestap.getDifference();
		float seriesnthdigit = requestap.getNumberofSeries();
		
		float sumofSeries = (seriesnthdigit/2)*((2*firstdigit)+(((seriesnthdigit-1)*diff)));
		//float sumofSeries = (seriesnthdigit/2)*(2*firstdigit+(seriesnthdigit-1)*diff);
		//float sum = (seriesnthdigit / 2) * (2 * firstdigit + (seriesnthdigit - 1) * diff);
		
		ArithmeticResponse response = new ArithmeticResponse();
		response.setOutcomeCode(200);
		response.setOutcomeMessage("Succesfully calculated the sum of the Arithmetic progression series");
		response.setSumofArithmeticProg(sumofSeries);
		
		StringBuilder test = new StringBuilder();
		//test.append(firstdigit + " ");
		for(int i=1; i<=seriesnthdigit; i++) {
			
			test.append(firstdigit + " ");
			firstdigit = firstdigit + diff;
			
		}
		
		System.out.println("The value of the series is " + " " + test);
	//	System.out.println("The value of the series is " + " " + sumofSeries);
	//	System.out.println("The value of the series is " + " " + sum);
		
		
		
		return response;
	}

}
