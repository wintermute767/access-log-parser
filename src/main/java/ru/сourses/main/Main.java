package ru.сourses.main;


import ru.сourses.geometry.Point;

public class Main {
    public static void main(String[] args) {
        Point point1 = new Point(3, 5);
        Point point2 = new Point(3, 5);

        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point1.equals(point2));

        Point point3= point1.clone();
        System.out.println(point3);
    }
}