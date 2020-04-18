package com.datastructures.maths.arithmeticprogression.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

	private int outComeCode;
	private String outComeMessage;
	private String developerMessage;

}
