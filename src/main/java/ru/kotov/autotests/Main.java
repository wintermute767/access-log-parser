package ru.kotov.autotests;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task4();
    }

    //задание 1
    public static void task1() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        System.out.printf("Выводит строку, в которой будут записаны все числа от 0 до %d (включительно)" +
                "\nРезультат: %s", x, listNums(x));
    }

    public static String listNums(int x) {
        if (x >= 0) {
            String result = "";
            for (int i = 0; i <= x; i++) {
                result = result + " " + i;
            }
            return result;
        }
        return "значения должны быть от 0 и выше";
    }

    //задание 2
    public static void task2() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        System.out.printf("Выводит строку, в которой будут записаны все числа от %d до 0 (включительно)" +
                "\nРезультат: %s", x, reverseListNums(x));
    }

    public static String reverseListNums(int x) {
        if (x >= 0) {
            String result = "";
            for (int i = x; i >= 0; i--) {
                result = result + " " + i;
            }
            return result;
        }
        return "значения должны быть от 0 и выше";
    }

    //задание 3
    public static void task3() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        System.out.printf("Выводит строку, в которой будут записаны все четные числа от 0 до %d (включительно)" +
                "\nРезультат: %s", x, chet(x));
    }

    public static String chet(int x) {
        if (x >= 0) {
            String result = "";
            for (int i = 0; i <= x; i = i + 2) {
                result = result + " " + i;
            }
            return result;
        }
        return "значения должны быть от 0 и выше";
    }

    //задание 4
    public static void task4() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        System.out.println("Введите число и нажмите <Enter>:");
        int y = new Scanner(System.in).nextInt();
        System.out.printf("Возвращает  результат возведения %d в степень %d:" +
                "\nРезультат : %d ", x, y, pow(x, y));
    }

    public static int pow(int x, int y) {
        int result=1;
        for (int i = 0; i < y; i++) {
            result = result * x;
        }
        return result;
    }
}