package ru.kotov.autotests;

public class Main {
    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(-30, 15);
        Fraction fraction2 = new Fraction(28, 7);
        Fraction fraction3 = new Fraction(7, 2);
        System.out.println("int 1: "+fraction1.intValue()+", int 2: "+fraction2.intValue()+", int 3: "+fraction3.intValue());
        System.out.println("long 1: "+fraction1.longValue()+", long 2: "+fraction2.longValue()+", long 3: "+fraction3.longValue());
        System.out.println("double 1: "+fraction1.doubleValue()+", double 2: "+fraction2.doubleValue()+", double 3: "+fraction3.doubleValue());
        System.out.println("float 1: "+fraction1.floatValue()+", float 2: "+fraction2.floatValue()+", float 3: "+fraction3.floatValue());
    }

}