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

        String operatorPattern = "(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)";
        String[] tokens = expression.split(operatorPattern);

        int operand = 0;
        String operator = "+";

        for (String token : tokens) {
            if (token.matches("[0-9]+")) {
                operand = recalculateOperand(token, operand, operator);
            } else if (token.matches(".*[-+*/].*"))  {
                operator = token;
            } else {
                System.out.println("invalid input");
                System.exit(0);
            }

        }
        System.out.println(operand);
        return null;
    }

    private static int recalculateOperand(String token, int operand, String operator) {

        if (operator.equals("+")) {
            return operand + Integer.parseInt(token);
        }
        if (operator.equals("*")) {
            return operand * Integer.parseInt(token);
        }
        if (operator.equals("-")) {
            return operand - Integer.parseInt(token);
        }
        if (operator.equals("/")) {
            return operand / Integer.parseInt(token);
        }
        return Integer.MIN_VALUE;
    }
}
