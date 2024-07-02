package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

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
}
