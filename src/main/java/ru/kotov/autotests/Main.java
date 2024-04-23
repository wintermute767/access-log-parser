package ru.kotov.autotests;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        task8();
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
        int result = 1;
        for (int i = 0; i < y; i++) {
            result = result * x;
        }
        return result;
    }

    //задание 5
    public static void task5() {
        System.out.println("Введите число и нажмите <Enter>:");
        long x = new Scanner(System.in).nextLong();
        try {
            System.out.printf("Выводит количество знаков в числе x" +
                    "\nРезультат: %s", numLen(x));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int numLen(long x) throws Exception {
        if (x > 0) {
            int i = 0;
            while (x > 0) {
                x = Math.round(x / 10);
                i++;
            }
            return i;
        } else if (x == 0) {
            return 1;
        } else {
            throw new Exception("x должно быть от 0 и выше");
        }
    }

    //задание 6
    public static void task6() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        System.out.printf("Выводит возвращал true, если все знаки числа одинаковы" +
                "\nРезультат: %s", equalNum(x));
    }

    public static boolean equalNum(int x) {
        Set numbers = new HashSet();
        while (x > 0) {
            numbers.add(x % 10);
            x = x / 10;
        }
        if (numbers.size() == 1) {
            return true;
        }
        return false;
    }

    //задание 7
    public static void task7() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        System.out.printf("Выводит на экран квадрат из символов ‘*’");
        square(x);
    }

    public static void square(int x) {
        String resultString = "";
        for (int i = 0; i < x; i++) {
            resultString = resultString + "*";
        }
        String resultSquare = "";
        for (int k = 0; k < x; k++) {
            resultSquare = resultSquare + "\n" + resultString;
        }
        System.out.printf("Результат:\n%s", resultSquare);
    }

    //задание 8
    public static void task8() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        System.out.println("Выводит на экран треугольник из символов ‘*’");
        rightTriangle(x);
    }

    public static void rightTriangle(int x) {
        List<String> resultTriangle = new ArrayList<>();
        for (int i = 1; i <= x; i++) {
            resultTriangle.add("*".repeat(i)+ " ".repeat(x - i));
        }
        System.out.printf("Результат:\n%s", String.join("\n", resultTriangle));
    }

    //задание 9
    public static void task9() {
        guessGame();
    }

    public static void guessGame() {
        int randomNum = 3;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("What number am I thinking (0 to 9)? :");
        int i =0;
        while (true){
            int x = sc.nextInt();
            i++;
            if (x != randomNum) {
                System.out.println("No, try again");
            } else {
                System.out.println("Yes, it`s " + randomNum);
                System.out.println("Attempts " + i);
                break;
            }
        }

    }
}