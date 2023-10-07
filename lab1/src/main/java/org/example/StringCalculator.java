package org.example;
public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String if_delimiter = "";
        String[] numberArray;
        if (numbers.startsWith("//")) {
            int end_index = numbers.length();
            char delimiter = numbers.charAt(2);
            if(numbers.contains(",")) numbers = numbers.replace(',', delimiter);
            if(numbers.contains("\n")) numbers = numbers.replace('\n', delimiter);
            numberArray = numbers.substring(4, end_index).split(String.valueOf("\\" + delimiter));
        } else {
            numberArray = numbers.split("[,\\n]");
        }
        int sum = 0;


        for (String number : numberArray) {
            try {
                int num = Integer.parseInt(number);
                sum += num;
            } catch (NumberFormatException e) {
                return 0;
            }
        }

        return sum;
    }


    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        String input = "//,\n1,2,3";
        int result = calculator.add(input);
        System.out.println("Сума: " + result);
    }
}
