package ru.kotov.autotests;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        CoordinatePoint startPointLine1 = new CoordinatePoint(1,3);
        CoordinatePoint endPointLine1 = new CoordinatePoint(5,8);

        CoordinatePoint startPointLine2 = new CoordinatePoint(10,11);
        CoordinatePoint endPointLine2 = new CoordinatePoint(15,19);

        Line line1 = new Line(startPointLine1, endPointLine1);
        Line line2 = new Line(startPointLine2,endPointLine2);
        Line line3 = new Line(endPointLine1,startPointLine2);

        System.out.println("Было:");
        System.out.println("1: " + line1.toString());
        System.out.println("2: " + line2.toString());
        System.out.println("3: " + line3.toString());
        System.out.println("Сумма длин 3 линий: "+ (line1.getLength()+ line2.getLength()+ line3.getLength()) );

        System.out.println("Изменили координаты конечной точки линии 1 и начальной точки линии 2:");
        endPointLine1.setNewCoordinate(30,40);
        startPointLine2.setNewCoordinate(35,45);

        System.out.println("Стало:");
        System.out.println("1: " + line1.toString());
        System.out.println("2: " + line2.toString());
        System.out.println("3: " + line3.toString());
        System.out.println("Сумма длин 3 линий: "+ (line1.getLength() + line2.getLength() + line3.getLength()) );

    }
}