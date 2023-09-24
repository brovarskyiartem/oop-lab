package org.example;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String[] numberArray = numbers.split("[,\\n]");
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
        String input = "";
        int result = calculator.add(input);
        System.out.println("Сума: " + result);
    }
}