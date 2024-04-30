package ru.kotov.autotests;

public class Main {
    public static void main(String[] args) {

        System.out.println(sumAll(new Number[]{Integer.valueOf(2),new Fraction(3,5),Double.valueOf(2.3)}));
        System.out.println(sumAll(new Number[]{Double.valueOf(3.6),new Fraction(49,12),Integer.valueOf(3),new Fraction(3,2)}));
        System.out.println(sumAll(new Number[]{new Fraction(1,3),Integer.valueOf(1)}));

    }

    public static double sumAll(Number[] number) {
        float result = number[0].floatValue();
        for (int i = 1; i < number.length; i++) {
            result=Float.sum(result,number[i].floatValue());
        }
        return result;
    }
}