package ru.kotov.autotests;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task2();
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
                "\nРезультат : %d", x,y, safeDiv(x,y));
    }

    public static int safeDiv(int x, int y) {
        Integer tempY = y;
        if (tempY.equals(0)) {
            return 0;
        }
        return x/y;
    }

}