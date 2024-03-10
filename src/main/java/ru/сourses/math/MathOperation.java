package ru.сourses.math;

public class MathOperation {
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
        return (double) a/b;}
    public static double sumAll(Number[] number) {
        float result = number[0].floatValue();
        for (int i = 1; i < number.length; i++) {
            result=Float.sum(result,number[i].floatValue());
        }
        return result;
    }
}
