package org.example;
import java.util.ArrayList;
import java.util.List;
public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String[] numberArray;
        if (numbers.startsWith("//")) {
            int end_index = numbers.length();
            char delimiter = numbers.charAt(2);
            numberArray = numbers.substring(4, end_index).split(String.valueOf("\\" + delimiter));
        } else {
            numberArray = numbers.split("[,\\n]");
        }
        int sum = 0;

        List<Integer> negativenumberArray = new ArrayList<>();
        for (String number_neg : numberArray) {
            try {
                int num = Integer.parseInt(number_neg);
                if (num < 0) {
                    negativenumberArray.add(num);
                } else if(num > 1000) {
                 continue;
                }
                else {
                    sum += num;
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException("Not correct input");
            }
        }
        if (!negativenumberArray.isEmpty()) {
            throw new RuntimeException("Negative numbers are not allowed: " + negativenumberArray);
        }
        return sum;
    }
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        String input = "//.\n1.2";
        try {
            int result = calculator.add(input);
            System.out.println("Сума: " + result);
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            }
        }
    }