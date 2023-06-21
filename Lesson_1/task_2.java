package Lesson_1;
// 2) Вывести все простые числа от 1 до 1000
public class task_2 {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            if (isPrime(i)){
                if (i != 2) {
                    System.out.print(", ");
                }
                System.out.printf("%d", i);  
            }
        }
    }

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } 

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
