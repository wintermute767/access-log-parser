package ru.сourses.math;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class MathOperation {

    public static double stringToPower(String a, String b){
        int intA = parseInt(a);
        int intB = parseInt(b);
        return pow(Double.valueOf(a),Double.valueOf(b));
    }
    public static Integer addition(Integer a, Integer b){
        return a+b;
    }
    public static Integer subtraction(Integer a, Integer b){
        return a-b;
    }
    public static Integer multiplication(Integer a, Integer b){
        return a*b;
    }
    public static Double division(Integer a, Integer b){
        return (double) a/b;}
    public static double sumAll(Number[] number) {
        float result = number[0].floatValue();
        for (int i = 1; i < number.length; i++) {
            result=Float.sum(result,number[i].floatValue());
        }
        return result;
    }
}
