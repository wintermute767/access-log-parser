package ru.kotov.autotests;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        PolyLine polyLine = new PolyLine();
        polyLine.setArrayCoordinatePoint(new CoordinatePoint[]{
                new CoordinatePoint(1, 5),
                new CoordinatePoint(2, 8),
                new CoordinatePoint(5, 3),
                new CoordinatePoint(8, 9)});
        System.out.println("Создана новая PolyLine: " + polyLine.toString());
        double sumLinesLengthFromMethod = polyLine.getLength();
        System.out.println("Длинна из метода getLength: " + sumLinesLengthFromMethod);

        Line[] lines = polyLine.getLines();
        System.out.println("Oтдельные линии:");
        double sumLinesLength = 0;
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i].toString());
            sumLinesLength = sumLinesLength + lines[i].getLength();
        }
        System.out.println("Длина отдельно: " + sumLinesLength);
        System.out.println("Совпадают ли длины: " + (sumLinesLength==sumLinesLengthFromMethod));

        System.out.println("Изменим координаты точки №2 на {12,8}");
        polyLine.changeCoordinatePoint(2, new CoordinatePoint(12,8));
        System.out.println("Создана новая PolyLine: " + polyLine.toString());
         sumLinesLengthFromMethod = polyLine.getLength();
        System.out.println("Длинна из метода getLength: " + sumLinesLengthFromMethod);

         lines = polyLine.getLines();
        System.out.println("Oтдельные линии:");
         sumLinesLength = 0;
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i].toString());
            sumLinesLength = sumLinesLength + lines[i].getLength();
        }
        System.out.println("Длина отдельно: " + sumLinesLength);
        System.out.println("Совпадают ли длины: " + (sumLinesLength==sumLinesLengthFromMethod));
    }
}