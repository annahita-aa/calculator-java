package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    private String expression;
    private double operand = 0;
    private String operator = "+";
    private List<String> tokens;

    private String repalceNumber;


    public List<String> enterYourExpression() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expression: ");
        expression = scanner.nextLine();
        // Split by valid numbers and special characters
        return tokens = new ArrayList<>(Arrays.asList(expression.split("(?<=\\d)(?=[^\\d.])|(?<=[^\\d.])(?=\\d)")));
    }

    public void calculateExpressionWithoutPriorities(List<String> tokens) {

        for (String token : tokens) {
            if (token.matches("[0-9.]+")) {
                operand = recalculateOperand(token, operand, operator);
            } else if (token.matches("^[+*/-]$")) {
                operator = token;
            } else {
                System.err.println("invalid operator: " + token);
            }

        }
        System.out.println(operand);

    }
    public void calculateExpressionWithPriorities(List<String> tokens) {

        for (int i = 0; i < tokens.toArray().length; i++) {
            if (tokens.get(i).matches("^[*/]$")) {
                if (tokens.get(i).equals("*")) {
                    repalceNumber = Double.toString(Double.parseDouble(tokens.get(i - 1)) * Double.parseDouble(tokens.get(i + 1)));
                } else {
                    repalceNumber = Double.toString(Double.parseDouble(tokens.get(i - 1)) / Double.parseDouble(tokens.get(i + 1)));
                }
                tokens.set(i - 1, repalceNumber);
                tokens.remove(i);
                tokens.remove(i);
                i--;
                continue;
            }
            if (tokens.get(i).matches("^[+-]$")) {
                continue;
            }

        }
        operand = 0;
        operator ="+";
        calculateExpressionWithoutPriorities(tokens);

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
            System.err.println("this is not a valid number: " + token);
            System.err.println("this is your final calculated before input invalid number: ");
        }
        return operand;
    }
}
