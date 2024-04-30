package ru.сourses.main;


import ru.сourses.geometry.Point;
import ru.сourses.geometry.PolyLine;


public class Main {
    public static void main(String[] args) {
        PolyLine line1 = new PolyLine(new Point(1, 3), new Point(5, 8), new Point(12, 15));
        PolyLine line2 = new PolyLine(new Point(1, 3), new Point(5, 8), new Point(12, 15));
        PolyLine line3 = new PolyLine(new Point(1, 3), new Point(5, 8), new Point(17, 25));


        System.out.println("Сравнение двух одинаковых PolyLine");
        System.out.println(line1.equals(line2));
        System.out.println("Сравнение двух разных PolyLine");
        System.out.println(line1.equals(line3));

    }
}