package org.example;

import java.util.List;
import java.util.Scanner;

/**
 * Calculator Without operator priority
 * and
 * Calculator With operator priority
 */
public class App {
    public static void main(String[] args) {

        Calculator calc1 = new Calculator();
        List<String> tokens= calc1.enterYourExpression();
        System.out.println("this is your answer without priorities: ");
        calc1.calculateExpressionWithoutPriorities(tokens);
        System.out.println("this is your answer with priorities: ");
        calc1.calculateExpressionWithPriorities(tokens);


    }
}
