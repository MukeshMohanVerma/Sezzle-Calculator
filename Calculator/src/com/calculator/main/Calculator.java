package com.calculator.main;

import java.util.Stack;

import com.calculator.utils.Utils;

public class Calculator {

	private Calculator() {}
	
	private static Stack<Double> numbers = null;
	
	public static double calculate(char [] inputValues) {
		
		int index = 0;
        char minus = '-';
        numbers = new Stack<Double>();
        Stack<Character> operators = new Stack<Character>();
        StringBuffer value = new StringBuffer();
        
        while ( index < inputValues.length ) {
        	char input = inputValues[index];
        	value.setLength(0);
        	
        	// Getting whole number because number can be decimal and more that 1 digit
            if (Utils.isNum(input) || Utils.isDecimal(input)) {
                value.append(input);
                int nextIndex = index + 1;
                if(nextIndex < inputValues.length) {
                	while (nextIndex < inputValues.length) {
                		char nextInput = inputValues[nextIndex];
                		if (Utils.isNum(nextInput) || Utils.isDecimal(nextInput)){
                			value.append(nextInput);
                			nextIndex++;
                		} else {
                			break;
                		}
                	}
                }
                numbers.push(Double.parseDouble(value.toString()));
                index = nextIndex;
            }

            //If starting number is negative get whole number because number can have more that 1 digit
            else if (input == minus && index == 0) {
            	value.append(input);
                int nextIndex = index + 1;
                while (nextIndex < inputValues.length) {
                	char nextInput = inputValues[nextIndex];
                	if (Utils.isNum(nextInput) || Utils.isDecimal(nextInput)){
                		value.append(nextInput);
                		nextIndex++;
                	} else {
                		break;
                	}
                }
                numbers.push(Double.parseDouble(value.toString()));
                index = nextIndex;
            }


            // If Current token is an operator and execute expression if operator has priority to execute as per BODMAS.
            else if (Utils.isOperator(input)) {
                while (!operators.empty() && !numbers.empty() && Utils.hasPriorityOperator(operators.peek())) {
                    double val1 = numbers.pop();
                    double val2 = 0;
                    if (!numbers.empty()) {
                        val2 = numbers.pop();
                    }
                    numbers.push(executeExpression(operators.pop(), val1, val2));
                }
                operators.push(input);
                index++;
            }
        }

        // Execute remaining values
        while (!operators.empty()) {
        	double val1 = numbers.pop();
            double val2 = 0;
            if (!numbers.empty()) {
                val2 = numbers.pop();
            }
            numbers.push(executeExpression(operators.pop(), val1, val2));
        }
        
        return numbers.pop();
		
	}
	
	public static double executeExpression(char operator, double val2, double val1) {
		
		switch (operator) {
		
		case '+':
			return val1 + val2;
		
		case '-':
			return val1 - val2;
		
		case '*':
			return val1 * val2;
		
		case '/':
			if (val2 == 0) {
				numbers.clear();
				System.out.println("Divide by zero is not possible");
			}else {
				return val1 / val2;
			}
		}
		return 0;
		
	}
}
