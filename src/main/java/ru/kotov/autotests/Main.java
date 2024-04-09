package ru.kotov.autotests;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task4();
    }

    //задание 1
    public static void task1() {
        System.out.println("Введите число и нажмите <Enter>:");
        double x = new Scanner(System.in).nextDouble();
        System.out.printf("Получим только дробную часть с 3 знаками после запятой от числа %f." +
                "\nРезультат : %.3f", x, fraction(x));
    }

    public static double fraction(double x) {
        //получим целую часть
        double integerPartOfNumber = Math.floor(x);
        //получим дробную часть
        double fraction = x - integerPartOfNumber;
        //круглим до 3 знаков после запятой
        return Math.floor(fraction * 1000) / 1000;
    }

    //задание 2
    public static void task2() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        System.out.printf("результат сложения двух последних знаков числа %d." +
                "\nРезультат : %d", x, sumLastNums(x));
    }

    public static int sumLastNums(int x) {
        //получим последнее число
        int a = x % 10;
        //получим предпоследнее число
        int b = x % 100 / 10;
        return a + b;
    }

    //задание 3
    public static void task3() {
        System.out.println("Введите число и нажмите <Enter>:");
        String x = new Scanner(System.in).next();
        System.out.printf("Получим преобразование цифры в соответствующее число из таблицы ASCII." +
                "\nРезультат : %d", charToNum(x.charAt(0)));
    }

    public static int charToNum(char x) {
        return x;
    }

    //задание 4
    public static void task4() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        try {
            System.out.printf("Получим результат - ответ на вопрос: положительное число?" +
                    "\nРезультат : %b", isPositive(x));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isPositive(int x) throws Exception {
        if (x == 0) {
            throw new Exception("Нельзя указывать ноль, так как он не отрицательный или положительный, а в сигнатуре метода это не предусмотренно!");
        }
        return x > 0;
    }
}