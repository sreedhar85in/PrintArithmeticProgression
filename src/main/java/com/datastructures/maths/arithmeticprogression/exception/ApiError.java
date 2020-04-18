package com.datastructures.maths.arithmeticprogression.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class ApiError {

	private int outComeCode;
	private String outComeMessage;
	private String developerMessage;

}
