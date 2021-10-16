package com.calculator.utils;

import com.calculator.constants.Constants;

public class Utils {

	private Utils() {}
	
	public static boolean isNum(char n) {

		return n >= Constants.ZERO && n <= Constants.NINE;
	
	}
	
	public static boolean isOperator(char o) {
	
		return o == Constants.PLUS || o == Constants.MINUS || o == Constants.MULTIPLY || o == Constants.DIVIDE;
	
	}
	
	public static boolean isDecimal(char o) {
	
		return o == Constants.DECIMAL;

	}
	
	public static boolean hasPriorityOperator(char operator) {
	
		return (operator == Constants.MULTIPLY || operator == Constants.DIVIDE);
	
	}
	
}
