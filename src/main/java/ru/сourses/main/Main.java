package ru.сourses.main;

import java.awt.*;


public class Main {
    public static void main(String[] args) {
        Point pointFromAwt = new Point(1, 3);
        ru.сourses.geometry.Point pointFromGeometryPoint = new ru.сourses.geometry.Point(3, 4);

        System.out.println(pointFromAwt);
        System.out.println(pointFromGeometryPoint);
    }
}