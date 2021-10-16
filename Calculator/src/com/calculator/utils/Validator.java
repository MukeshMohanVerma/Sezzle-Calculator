package com.calculator.utils;

import com.calculator.constants.Constants;

public class Validator {

	private Validator() {}
	
	public static boolean isValidExpression(String expression) {
		
		char [] input = expression.trim().toCharArray();
		return isEmpty(expression) && hasDigitOnly(input) && hasValidStart(input[0]) && hasValidOperatorAndDecimalSequence(input);
		
	}
	
	public static boolean isEmpty(String input) {
		
		boolean valid = true;
		if(input.isEmpty()) {
			System.out.println("Experssion can not be empty");
			valid = false;
		}
		return valid;
	
	}
	
	public static boolean hasDigitOnly(char [] input) {
		
		boolean valid = true;
		int index = 0;
		while(index < input.length) {
			char ch = input[index];
			if(!Utils.isNum(ch) && !Utils.isOperator(ch) && !Utils.isDecimal(ch)) {
				System.out.println("Expression can have +-*/ operators and 0-9 digits only");
				valid  = false;
				break;
			}
			index++;
		}
		return valid;
		
	}
	
	public static boolean hasValidStart(char c) {
		
		if(!Utils.isNum(c) && !Utils.isDecimal(c) && c != '-') {
			System.out.println("Expression can be start with - only");
			return false;
		}
		return true;
		
	}
	
	public static boolean hasValidOperatorAndDecimalSequence(char [] inputData) {
		
		boolean valid = true;
		int index = 0;
		while(index < inputData.length) {
			char c = inputData[index];
			if(Utils.isOperator(c) || Utils.isDecimal(c)) {
				char sequanceType =  Utils.isOperator(c) ? Constants.SEQUANCE_TYPE_OPERATOR : Constants.SEQUANCE_TYPE_DECIMAL;
				valid = checkNextSequence(index, inputData, sequanceType);
				if(!valid) {
					break;
				}
			}
			index ++;
		}
		return valid;
		
	}
	
	public static boolean checkNextSequence(int index, char [] inputData, char sequanceType) {
		
		if(index == inputData.length-1) {
			System.out.println("Please complete your expression at last");
			return false;
		}else if(sequanceType == 'o'){
			if(Utils.isOperator(inputData[index + 1])) {
				System.out.println("Two operator can not be together");
				return false;
			}
		}else {
			if(Utils.isDecimal(inputData[index + 1])) {
				System.out.println("Two decimal can not be together");
				return false;
			}
		}
		return true;
		
	}
	
}
