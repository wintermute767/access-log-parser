package ru.сourses.main;

import static ru.сourses.math.MathOperation.stringToPower;

public class Main {
    public static void main(String[] args) {
        System.out.println("Возведение в степень: "+ stringToPower(args[0],args[1]));
    }
}