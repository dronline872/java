package Lesson_4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class task_1 {
    public static void main(String[] args) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        deque1.add(3);
        deque1.add(2);
        deque1.add(1);

        Deque<Integer> deque2 = new ArrayDeque<>();
        deque2.add(5);
        deque2.add(4);
        deque2.add(3);

        StringBuilder str1 = new StringBuilder();
        for (int i = deque1.size()-1; i >=0; i--) {
            str1.append(deque1.pollLast());
        }

        StringBuilder str2 = new StringBuilder();
        for (int i = deque2.size()-1; i >=0; i--) {
            str2.append(deque2.pollLast());
        }

        int number1 = Integer.parseInt(str1.toString());
        int number2 = Integer.parseInt(str2.toString());

        multiplication(number1, number2);
        summary(number1, number2);
    }

    public static void multiplication(int number1, int number2) {
        Integer sum = number1 * number2;
        LinkedList<Integer> result = new LinkedList<>();
        while (sum > 0) {
            int digit = sum % 10;
            result.addFirst(digit);
            sum /= 10;
        }
        System.out.println(result);
    }

    public static void summary(int number1, int number2) {
        Integer sum = number1 + number2;
        LinkedList<Integer> result = new LinkedList<>();
        while (sum > 0) {
            int digit = sum % 10;
            result.addFirst(digit);
            sum /= 10;
        }
        System.out.println(result);
    }

}