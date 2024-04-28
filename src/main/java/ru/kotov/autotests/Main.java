package ru.kotov.autotests;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        CoordinatePoint point1 = new CoordinatePoint(1, 3);
        CoordinatePoint point2 = new CoordinatePoint(1, 3);
        CoordinatePoint point3 = new CoordinatePoint(5, 8);

        System.out.println("Сравнение точек " + point1.toString() + " и " + point2.toString() + ": " + (point1 == point2));
        System.out.println("Сравнение точек " + point2.toString() + " и " + point3.toString() + ": " + (point2 == point3));
        System.out.println("Сравнение точек " + point1.toString() + " и " + point3.toString() + ": " + (point1 == point3));
    }
}