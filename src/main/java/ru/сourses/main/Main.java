package ru.сourses.main;


import ru.сourses.geometry.Point;


public class Main {
    public static void main(String[] args) {
        ru.сourses.geometry.Line line1 = new ru.сourses.geometry.Line(new Point(1, 3), new Point(5, 8));
        ru.сourses.geometry.Line line2 = new ru.сourses.geometry.Line(new Point(1, 3), new Point(5, 8));

        System.out.println("Сравнение двух отдельных объектов");
        System.out.println(line1 == line2);
        System.out.println(line1.equals(line2));

        System.out.println("Сравнение объекта и его клона");
        ru.сourses.geometry.Line line3 = line1.clone();
        System.out.println(line1 == line3);
        System.out.println(line1.equals(line3));
    }
}