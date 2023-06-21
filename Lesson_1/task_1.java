package Lesson_1;

// 1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
public class task_1 {
    public static void main(String[] args) {
        // треугольное число
        System.out.println(triangular(4));
        // факториал
        System.out.println(factorial(4));
    }

    static int triangular(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result = result + i;
        }

        return result;
    }

    static int factorial(int n) {
        if (n < 2) {
            return 1;
        } 

        return n * factorial(n-1);
    }
}
