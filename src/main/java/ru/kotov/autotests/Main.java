package ru.kotov.autotests;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task5();
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
        System.out.printf("Получим результат - ответ на вопрос: положительное число?" +
                "\nРезультат : %b", isPositive(x));
    }

    public static boolean isPositive(int x) {
        return x >= 0;
    }

    //задание 5
    public static void task5() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        System.out.printf("Получим результат - ответ на вопрос: двузначное число?" +
                "\nРезультат : %b", is2Digits(x));
    }

    public static boolean is2Digits(int x) {
        String strNumber = String.valueOf(x);
        if (strNumber.length() == 2) {
            return true;
        }
        return false;
    }
}