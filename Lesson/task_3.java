package lessons.Lesson;

import java.util.Scanner;

// 3) Реализовать простой калькулятор (+-/*)
public class task_3 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        if (!iScanner.hasNextInt()) {
            System.out.println("Введено не число!");
        }
        int firstNumber = iScanner.nextInt();        

        System.out.print("Введите второе число: "); 
        if (!iScanner.hasNextInt()) {
            System.out.println("Введено не число!");
        }
        int secondNumber = iScanner.nextInt();

        System.out.print("Введите оператор");
        char operator = iScanner.next().charAt(0);
        double result = 0;
        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
            
                } else {
                    System.out.println("Деление на ноль!");
                }
                break;
            default:
                System.out.println("Неверный оператор!");
                break;
        }

        System.out.println("Результат: " + result);
        iScanner.close();
    }


}
