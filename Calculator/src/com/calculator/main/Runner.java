package com.calculator.main;

import java.util.Scanner;

import com.calculator.utils.Filter;
import com.calculator.utils.Validator;

public class Runner {

	public static void main(String[] args) {
		System.out.print("Enter expression = ");
		Scanner input = new Scanner(System.in);
		String expression = Filter.removeBrackets(input.nextLine());
		if(Validator.isValidExpression(expression)) {
			System.out.println("Answer = " + Calculator.calculate(expression.toCharArray()));
		}
	}
}
