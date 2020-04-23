package com.datastructures.maths.arithmeticprogression.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastructures.maths.arithmeticprogression.model.GeometricResponse;
import com.datastructures.maths.arithmeticprogression.model.GeometricSumResponse;

@Service
public class GeometricService {

	public GeometricResponse PrintSeries(int ratio, int firstNumber, int numberofSeries) {
		
		//formuala is a* r power n-1)
		// TODO Auto-generated method stub
		StringBuilder series = new StringBuilder();
		//int currentTerm = firstNumber;
		for(int i=0;i<numberofSeries;i++) {
			if(i==numberofSeries-1) {
				int currentTerm = firstNumber * (int) Math.pow(ratio, i);
				series.append(currentTerm);
				
			}
			else {
			int currentTerm = firstNumber * (int) Math.pow(ratio, i);
			series.append(currentTerm + "," + " ");
			}
			
		}
		GeometricResponse response = new GeometricResponse();
		response.setOutcomeCode(200);
		response.setOutcomeMessage("Success");
		response.setSeries(series);
		return response;
	}
	
	public GeometricSumResponse sum(float ratio, float firstNumber, float numberofSeries) {
		
		
		//formula = a(1-rpw n-1)/1-r
		
		//float sum = firstNumber*(1-(int) Math.pow(ratio, numberofSeries))/(1-ratio);
		
		float sum = (firstNumber * (1 - (int)(Math.pow(ratio, numberofSeries)))) /  
                (1 - ratio); 
		
		
		
		GeometricSumResponse response = new GeometricSumResponse();
		response.setOutcomeCode(200);
		response.setOutcomeMessage("Success");
		response.setSum(sum);
		return response;
		
		
		
	}

	
	
}
