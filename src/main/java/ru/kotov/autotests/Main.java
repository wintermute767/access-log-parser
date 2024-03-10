package ru.kotov.autotests;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите первое число и нажмите <Enter>: ");
        Integer a = new Scanner(System.in).nextInt();
        System.out.println("Введите второе число и нажмите <Enter>: ");
        Integer b = new Scanner(System.in).nextInt();
        System.out.printf("Сложение: %d + %d = %d\n",a,b,addition(a,b));
        System.out.printf("Вычитание: %d - %d = %d\n",a,b,subtraction(a,b));
        System.out.printf("Умножение: %d * %d = %d\n",a,b,multiplication(a,b));
        System.out.printf("Деление: %d : %d = %f\n",a,b,division(a,b));
    }
    private static Integer addition(Integer a, Integer b){
        return a+b;
    }
    private static Integer subtraction(Integer a, Integer b){
        return a-b;
    }
    private static Integer multiplication(Integer a, Integer b){
        return a*b;
    }
    private static Double division(Integer a, Integer b){
        return (double) a/b;
    }

}