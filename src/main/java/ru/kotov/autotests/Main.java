package ru.kotov.autotests;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task1();
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
        double integerPartOfNumber= Math.floor(x);
        //получим дробную часть
        double fraction =x-integerPartOfNumber;
        //круглим до 3 знаков после запятой
        return Math.floor( fraction * 1000) / 1000;
    }
}