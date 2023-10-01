package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String[] numberArray;
        if (numbers.startsWith("//")) {
            String delim = String.valueOf(numbers.charAt(2));
            if(!delim.equals("[")){
                int end_index = numbers.length();
                char delimiter = numbers.charAt(2);
                numberArray = numbers.substring(4, end_index).split(String.valueOf("\\" + delimiter));
            }else{
                numbers = numbers.replaceAll("(.)\\1+", "$1");
                numbers = numbers.replaceAll("[\n]+", "\n");
                String customDelim = numbers.substring(2, numbers.indexOf("\n"));
                String newNumbers = numbers.substring(numbers.indexOf("\n") + 1);
                customDelim = customDelim.replace("[", "");
                String[] delimArray = customDelim.split("]");
                for (String delimiter : delimArray) {
                    newNumbers = newNumbers.replaceAll(Pattern.quote(delimiter), ",");
                }
                newNumbers = newNumbers.replace("\n",",");
                numberArray = newNumbers.split(",");
            }
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
        String input = "//[{][*]\n1{2,,,,3\n\n\n3*2";
        try {
            int result = calculator.add(input);
            System.out.println("Сума: " + result);
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
        }
    }
}
