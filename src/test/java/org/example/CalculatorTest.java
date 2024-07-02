package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testEnterYourExpression() {
        Calculator calc = new Calculator();
        List<String> tokens = calc.enterYourExpression("3+5*2");
        assertEquals(List.of("3", "+", "5", "*", "2"), tokens);
    }

    @Test
    void testCalculateExpressionWithoutPriorities() {
        Calculator calc = new Calculator();
        List<String> tokens = List.of("3", "+", "5", "*", "2");
        calc.calculateExpressionWithoutPriorities(tokens);
        assertEquals(16.0, calc.getOperand());
    }

    @Test
    void testCalculateExpressionWithPriorities() {
        Calculator calc = new Calculator();
        List<String> tokens = List.of("3", "+", "5", "*", "2");
        calc.calculateExpressionWithPriorities(tokens);
        assertEquals(13.0, calc.getOperand());
    }

    @Test
    void testRecalculateOperand() {
        assertEquals(8.0, Calculator.recalculateOperand("5", 3.0, "+"));
        assertEquals(15.0, Calculator.recalculateOperand("5", 3.0, "*"));
        assertEquals(-2.0, Calculator.recalculateOperand("5", 3.0, "-"));
        assertEquals(0.6, Calculator.recalculateOperand("5", 3.0, "/"));
    }
}