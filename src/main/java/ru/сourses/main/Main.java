package ru.сourses.main;


import ru.сourses.dishes.LevelOfSharpness;
import ru.сourses.dishes.Sauce;


public class Main {
    public static void main(String[] args) {
        Sauce sause1 = new Sauce("Чили", LevelOfSharpness.VERY_HOT);
        Sauce sause2 = new Sauce("Майонезы", LevelOfSharpness.NOT_HOT);
        Sauce sause3 = new Sauce("Кетчупы", LevelOfSharpness.HOT);
        System.out.println(sause1);
        System.out.println(sause2);
        System.out.println(sause3);
    }
}