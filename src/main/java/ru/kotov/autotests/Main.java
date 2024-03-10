package ru.kotov.autotests;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task10();
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
        return x - x % 100 == 0;
    }

    //задание 6
    public static void task6() {
        System.out.println("Введите число и нажмите <Enter>:");
        String x = new Scanner(System.in).next();
        System.out.printf("Получим результат - ответ на вопрос: эта буква большая?" +
                "\nРезультат : %b", isUpperCase(x.charAt(0)));
    }

    public static boolean isUpperCase(char x) {
        return x <= 90;
    }

    //задание 7
    public static void task7() {
        System.out.println("Введите число A и нажмите <Enter>:");
        int a = new Scanner(System.in).nextInt();
        System.out.println("Введите число B и нажмите <Enter>:");
        int b = new Scanner(System.in).nextInt();
        System.out.println("Введите число N и нажмите <Enter>:");
        int num = new Scanner(System.in).nextInt();
        System.out.printf("Получим результат - ответ на вопрос: число N входит в диапазон от A до B или от В до А?" +
                "\nРезультат : %b", isInRange(a, b, num));
    }

    public static boolean isInRange(int a, int b, int num) {
        if (a > b) {
            a = a ^ b ^ (b = a);
        }
        if ((num > a && num < b) || num == a || num == b) {
            return true;
        }
        return false;
    }

    //задание 8
    public static void task8() {
        System.out.println("Введите число A и нажмите <Enter>:");
        int a = new Scanner(System.in).nextInt();
        System.out.println("Введите число B и нажмите <Enter>:");
        int b = new Scanner(System.in).nextInt();
        System.out.printf("Получим результат - ответ на вопрос: любое из принятых чисел делит другое нацело?" +
                "\nРезультат : %b", isDivisor(a, b));
    }

    public static boolean isDivisor(int a, int b) {
        boolean tempRemainderA = a % b == 0;
        boolean tempRemainderB = b % a == 0;
        if (tempRemainderA || tempRemainderB) {
            return true;
        }
        return false;
    }

    //задание 9
    public static void task9() {
        System.out.println("Введите число A и нажмите <Enter>:");
        int a = new Scanner(System.in).nextInt();
        System.out.println("Введите число B и нажмите <Enter>:");
        int b = new Scanner(System.in).nextInt();
        System.out.println("Введите число C и нажмите <Enter>:");
        int c = new Scanner(System.in).nextInt();
        System.out.printf("Получим результат - ответ на вопрос: все три полученных числа равны?" +
                "\nРезультат : %b", isEqual(a, b,c));
    }

    public static boolean isEqual (int a, int b, int c){
        Integer tempA= a;
        Integer tempB= b;
        Integer tempC= c;
        if (tempA.equals(tempB) && tempB.equals(tempC)) {
            return true;
        }
        return false;
    }
    //задание 10
    public static void task10() {
        System.out.printf("Получим результат - последовательное сложение остатков от деления на 10 пяти чисел: 5, 11, 123, 14, 1." +
                "\nРезультат : %d",lastNumSum(lastNumSum(lastNumSum(lastNumSum(5,11),123),14),1));
    }
    public static int lastNumSum(int a, int b){
        return (a%10)+(b%10);
    }
}