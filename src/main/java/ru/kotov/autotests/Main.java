package ru.kotov.autotests;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task11();
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

    //задание 6
    public static void task6() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        System.out.println("Введите число и нажмите <Enter>:");
        int y = new Scanner(System.in).nextInt();
        System.out.println("Введите число и нажмите <Enter>:");
        int z = new Scanner(System.in).nextInt();
        System.out.printf("Возвращает true, если два любых числа (из трех принятых) можно сложить так, чтобы получить третье: %d, %d, %d" +
                "\nРезультат : %b ", x, y, z, sum3(x, y, z));
    }

    public static boolean sum3(int x, int y, int z) {
        Boolean result1 = x + y == z;
        Boolean result2 = y + z == x;
        Boolean result3 = x + z == y;
        return result1 || result2 || result3;
    }

    //задание 7
    public static void task7() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        System.out.println("Введите число и нажмите <Enter>:");
        int y = new Scanner(System.in).nextInt();
        System.out.printf("Возвращает сумму чисел x и y. Однако, если сумма попадает в диапазон от [10, 19], то надо вернуть число 20: %d, %d" +
                "\nРезультат : %d ", x, y, sum2(x, y));
    }

    public static int sum2(int x, int y) {
        int result = x + y;
        if (result >= 10 && result <= 19) {
            return 20;
        }
        return result;
    }

    //задание 8
    public static void task8() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        System.out.printf("Возвращает true, если число x делится нацело на 3 или 5. " +
                "При этом, если оно делится и на 3, и на 5, то вернуть надо false: %d" +
                "\nРезультат : %b ", x, is35(x));
    }

    public static boolean is35(int x) {
        boolean result1 = x % 3 == 0;
        boolean result2 = x % 5 == 0;
        if ((result1 || result2) && ((result1 && result2) != true)) {
            return true;
        }
        return false;
    }

    //задание 9
    public static void task9() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        System.out.println("Введите число и нажмите <Enter>:");
        int y = new Scanner(System.in).nextInt();
        System.out.printf("Возвращает true, если одно из принятых методом чисел равно шести, или их сумма равна шести, или разница между ними равна шести: %d, %d" +
                "\nРезультат : %b ", x, y, magic6(x, y));
    }

    public static boolean magic6(int x, int y) {
        boolean result1 = (x == 6) || (y == 6);
        boolean result2 = (x + y == 6) || (x - y == 6) || (y - x == 6);
        if (result1 || result2) {
            return true;
        }
        return false;
    }

    //задание 10
    public static void task10() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        System.out.printf("Возвращает строку, в которой сначала будет число х, а затем одно из слов: год, года, лет." +
                "\nРезультат : %d %s", x, age(x));
    }

    public static String age(int x) {
        int remainder10 = x % 10;
        int remainder100 = x % 100;
        if (remainder10 == 1 && remainder100 != 11) {
            return "год";
        } else if (List.of(2, 3, 4).contains(remainder10) && !List.of(12, 13, 14).contains(remainder100)) {
            return "годa";
        }
        return "лет";
    }
    //задание 11
    public static void task11() {
        System.out.println("Введите число и нажмите <Enter>:");
        int x = new Scanner(System.in).nextInt();
        System.out.printf("Возвращает  строку, которая будет обозначать текущий день недели, где 1 - это понедельник, а 7 – воскресенье." +
                "\nРезультат: %s", day(x));
    }
    public static String day(int x){
        switch (x){
            case (1):
                return "понедельник";
            case (2):
                return "вторник";
            case (3):
                return "среда";
            case (4):
                return "четверг";
            case (5):
                return "пятница";
            case (6):
                return "суббота";
            case (7):
                return "воскресенье";
            default:
                break;
        }
        return "Нет такого дня в неделе. Выберите число от 1 до 7!";
    }
}