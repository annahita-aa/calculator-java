package org.example;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expression: ");
        String expression = scanner.nextLine();

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
