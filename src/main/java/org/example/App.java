package org.example;

import java.util.Scanner;

/**
 * Calculator Without operator priority
 */
public class App {
    public static void main(String[] args) {

        Calculator calc1 = new Calculator();
        String expression= calc1.enterYourExpression();
        calc1.calculateExpression(expression);


    }
}
