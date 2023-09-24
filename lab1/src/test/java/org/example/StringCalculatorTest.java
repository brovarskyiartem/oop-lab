package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class StringCalculatorTest {
    @Test
    public void step1_test0input() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("");
        assertEquals(0, result);
    }

    @Test
    public void step1_test_letterinput() {
        StringCalculator calculator = new StringCalculator();
        String input = "f";
        try {
            int result = calculator.add(input);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Not correct input", e.getMessage());
        }
        ;
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
        String input = "1,\n2";
        try {
            int result = calculator.add(input);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Not correct input", e.getMessage());
        }
        ;
    }

    @Test
    public void step3_test4_FalseRevers() {
        StringCalculator calculator = new StringCalculator();
        String input = "1\n,2";
        try {
            int result = calculator.add(input);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Not correct input", e.getMessage());
        }
        ;
    }

    @Test
    public void step4_test1_with_delimiter() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//;\n1;2;3");
        assertEquals(6, result);
    }

    @Test
    public void step4_test2_with_delimiter() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//*\n1*2");
        assertEquals(3, result);
    }

    @Test
    public void step4_test3_with_delimiter() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//{\n1{2");
        assertEquals(3, result);
    }
    @Test
        public void step5_test1_hNegativeNumbers() {

        StringCalculator calculator = new StringCalculator();
        String input = "1,-2,3";
           try {
              int result = calculator.add(input);
              fail("Expected RuntimeException");
          } catch (RuntimeException e) {
              assertEquals("Negative numbers are not allowed: [-2]", e.getMessage());
          }
      }
      @Test
      public void step5_test2_hNegativeNumbers() {
        StringCalculator calculator = new StringCalculator();
        String input = "1,-2,-3";
        try {
            int result = calculator.add(input);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Negative numbers are not allowed: [-2, -3]", e.getMessage());
        }
    }
    @Test
    public void step5_test3_NotNumbers() {
        StringCalculator calculator = new StringCalculator();
        String input = "1,adv";
        try {
            int result = calculator.add(input);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Not correct input", e.getMessage());
        }
    }
    @Test
    public void step6_test1_numbersbiggerthen1000() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1000,999,1002");
        assertEquals(1999, result);
    }
    @Test
    public void step6_test2_numbersbiggerthen1000() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1001,999,1002");
        assertEquals(999, result);
    }
    @Test
    public void step6_test3_numbersbiggerthen1000() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1001,1999,1002");
        assertEquals(0, result);
    }
    @Test
    public void step6_test4_numbersbiggerthen1000_and_negative() {
        StringCalculator calculator = new StringCalculator();
        String input = "1001,1999,-1002";
        try {
            int result = calculator.add(input);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Negative numbers are not allowed: [-1002]", e.getMessage());
        }
    }
    @Test
    public void step7_test1_with_delimiter() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//[{]\n1{{2");
        assertEquals(3, result);
    }
    @Test
    public void step7_test2_with_delimiter() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("//[*]\n1**2*3");
        assertEquals(6, result);
    }
    @Test
    public void step7_test3_with_delimiter() {
        StringCalculator calculator = new StringCalculator();
        String input = "//[*]\n1,*2*3";
        try {
            int result = calculator.add(input);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Not correct input", e.getMessage());
        }
    }
}

