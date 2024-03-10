package ru.kotov.autotests;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task5();
    }

    //задание 1
    public static void task1() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        System.out.printf("Получим модуль числа %d" +
                "\nРезультат : %d", x, abs(x));
    }

    public static int abs(int x) {
        if (x < 0) {
            return x * -1;
        }
        return x;
    }

    //задание 2
    public static void task2() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        System.out.println("Введите число и нажмите <Enter>:");
        int y = new Scanner(System.in).nextInt();
        System.out.printf("Получим результат деление %d на %d" +
                "\nРезультат : %d", x, y, safeDiv(x, y));
    }

    public static int safeDiv(int x, int y) {
        Integer tempY = y;
        if (tempY.equals(0)) {
            return 0;
        }
        return x / y;
    }

    //задание 3
    public static void task3() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        System.out.println("Введите число и нажмите <Enter>:");
        int y = new Scanner(System.in).nextInt();
        System.out.printf("Получим максимальное значение из двух чисел: %d на %d" +
                "\nРезультат : %d", x, y, max(x, y));
    }

    public static int max(int x, int y) {
        if (((Integer) x).intValue() > ((Integer) y).intValue()) {
            return x;
        }
        return y;
    }

    //задание 4
    public static void task4() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        System.out.println("Введите число и нажмите <Enter>:");
        int y = new Scanner(System.in).nextInt();
        System.out.printf("Получим знак операции сравнения двух чисел: %d на %d" +
                "\nРезультат : %d %s %d", x, y, x, makeDecision(x, y), y);
    }

    public static String makeDecision(int x, int y) {
        if (((Integer) x).intValue() > ((Integer) y).intValue()) {
            return ">";
        } else if (((Integer) x).intValue() < ((Integer) y).intValue()) {
            return "<";
        }
        return "=";
    }

    //задание 5
    public static void task5() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        System.out.println("Введите число и нажмите <Enter>:");
        int y = new Scanner(System.in).nextInt();
        System.out.println("Введите число и нажмите <Enter>:");
        int z = new Scanner(System.in).nextInt();
        System.out.printf("Получим максимальное из трех чисел: %d, %d, %d" +
                "\nРезультат : %d ", x, y, z, max3(x, y, z));
    }

    public static int max3(int x, int y, int z) {
        int maxValue;
        if (((Integer) x).intValue() > ((Integer) y).intValue()) {
            maxValue = x;
        } else {
            maxValue = y;
        }
        if (((Integer) maxValue).intValue() < ((Integer) z).intValue()) {
            maxValue = z;
        }
        return maxValue;
    }
}