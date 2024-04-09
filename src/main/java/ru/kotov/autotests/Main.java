package ru.kotov.autotests;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task1();
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
}