package com.calculator.utils;

public class Filter {

	private Filter() {}
	
	public static String removeBrackets(String input) {
		
		return input.replaceAll("\\{", "").replaceAll("\\}", "").replaceAll("\\(", "")
				.replaceAll("\\)", "").replaceAll("\\[", "").replaceAll("\\]", "");
		
	}
}
