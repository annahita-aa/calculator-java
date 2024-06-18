package org.example;

import java.util.Scanner;

public class Calculator {

    private String expression;


    public String enterYourExpression() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expression: ");
        return expression = scanner.nextLine();

    }

    public String calculateExpression(String expression){



        String[] tokens = expression.split("(?<=\\d)(?=[^\\d.])|(?<=[^\\d.])(?=\\d)"); // Split by valid numbers and special characters



        double operand = 0;
        String operator = "+";

        for (String token : tokens) {
            if (token.matches("[0-9.]+")) {
                operand = recalculateOperand(token, operand, operator);
            } else if (token.matches("^[+*/-]$"))  {
                operator = token;
            } else {
                System.err.println("invalid operator: " +token);
                System.exit(0);
            }

        }
        System.out.println(operand);
        return null;
    }

    private static double recalculateOperand(String token, Double operand, String operator) {



        try {
           double number = Double.parseDouble(token);
            if (operator.equals("+")) {
                return number = operand + number;
            }
            if (operator.equals("*")) {
                return number = operand * number;
            }
            if (operator.equals("-")) {
                return number = operand - number;
            }
            if (operator.equals("/")) {
                return number = operand / number;
            }
        } catch (NumberFormatException e) {
            System.err.println("this is not a valid number: "+ token);
            System.err.println("this is your final calculated before input invalid number: ");
        }
        return operand;
    }
}
