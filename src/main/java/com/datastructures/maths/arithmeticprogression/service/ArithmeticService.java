package com.datastructures.maths.arithmeticprogression.service;

import org.springframework.stereotype.Service;

import com.datastructures.maths.arithmeticprogression.exception.InternalException;
import com.datastructures.maths.arithmeticprogression.model.AirthmeticSeriesResponse;
import com.datastructures.maths.arithmeticprogression.model.ArithmeticResponse;
import com.datastructures.maths.arithmeticprogression.model.ArithmeticprogRequest;

@Service
public class ArithmeticService {
	
	
	public ArithmeticResponse sumofAP(ArithmeticprogRequest requestap) throws InternalException {
		
		float firstdigit = requestap.getFirstNumber();
		float diff = requestap.getDifference();
		float seriesnthdigit = requestap.getNumberofSeries();
		
		if(seriesnthdigit > 100) {
			
			throw new InternalException(200, "Internal Exception", " series is not allowed to print more than 100");
		}
		
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
			
			test.append(firstdigit + " " + ",");
			firstdigit = firstdigit + diff;
			
		}
		
		System.out.println("The value of the series is " + " " + test);
	//	System.out.println("The value of the series is " + " " + sumofSeries);
	//	System.out.println("The value of the series is " + " " + sum);
		
		
		
		return response;
	}
	
	public AirthmeticSeriesResponse seriesPrint(ArithmeticprogRequest requestap) throws InternalException {
		
		int firstdigit = requestap.getFirstNumber();
		int diff = requestap.getDifference();
		int seriesnthdigit = requestap.getNumberofSeries();
		
	if(seriesnthdigit > 100) {
			
			throw new InternalException(200, "Internal Exception", " series is not allowed to print more than 100");
		}
	
	
		StringBuilder test = new StringBuilder();
		//test.append(firstdigit + " ");
		for(int i=1; i<=seriesnthdigit; i++) {
			if(i==seriesnthdigit) {
				test.append(firstdigit);
				
			}
			else {
				test.append(firstdigit + "," + " ");
			firstdigit = firstdigit + diff;
			}
			
		}
		
		AirthmeticSeriesResponse response = new AirthmeticSeriesResponse();
		response.setOutcomeCode(200);
		response.setOutcomeMessage("Succesfully calculated the sum of the Arithmetic progression series");
		response.setSeries(test);
		
		return response;
	}

}
