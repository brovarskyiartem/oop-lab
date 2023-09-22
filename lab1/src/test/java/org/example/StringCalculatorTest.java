package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @Test
    public void step1_test0input() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("");
        assertEquals(0, result);
    }

    @Test
    public void step1_test1number() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1");
        assertEquals(1, result);
    }

    @Test
    public void step1_test2_1numbers() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1,2");
        assertEquals(3, result);

    }
    @Test
    public void step1_test2_2numbers() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("10,2");
        assertEquals(12, result);
    }
    @Test
    public void step2_test1_3numbers() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("10,2,2");
        assertEquals(14, result);
    }
    @Test
    public void step2_test2_2numbers() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("10,2,,");
        assertEquals(12, result);
    }
    @Test
    public void step3_test1_True() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1\n2,3,4");
        assertEquals(10, result);
    }
    @Test
    public void step3_test2_True() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1\n2\n3,4");
        assertEquals(10, result);
    }
    @Test
    public void step3_test3_False() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1,\n2");
        assertEquals(0, result);
    }
    @Test
    public void step3_test4_FalseRevers() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1\n,2");
        assertEquals(0, result);
    }
}
