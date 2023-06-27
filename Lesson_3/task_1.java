package Lesson_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task_1 {
      public static void main(String[] args) {
        List<Integer> numbers = generateRandomNumbers(10, 1, 100);
        System.out.println("Original list: " + numbers);

        removeEvenNumbers(numbers);
        System.out.println("List after removing even numbers: " + numbers);

        int minValue = findMinValue(numbers);
        System.out.println("Minimum value: " + minValue);

        int maxValue = findMaxValue(numbers);
        System.out.println("Maximum value: " + maxValue);

        double average = calculateAverage(numbers);
        System.out.println("Average value: " + average);
    }

    public static List<Integer> generateRandomNumbers(int count, int min, int max) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            numbers.add(randomNumber);
        }

        return numbers;
    }

    public static void removeEvenNumbers(List<Integer> numbers) {
        numbers.removeIf(n -> n % 2 == 0);
    }

    public static int findMinValue(List<Integer> numbers) {
        int min = numbers.get(0);
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int findMaxValue(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static double calculateAverage(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.size();
    }
}
