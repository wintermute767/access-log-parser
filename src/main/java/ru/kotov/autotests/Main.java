package ru.kotov.autotests;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        PolyLine polyLine = new PolyLine();
        polyLine.setArrayCoordinatePoint(new CoordinatePoint[]{
                new CoordinatePoint(1, 5),
                new CoordinatePoint(2, 8),
                new CoordinatePoint(5, 3),
                new CoordinatePoint(8, 9)});
        ClosedPolyLine closedPolyLine = new ClosedPolyLine();
        closedPolyLine.setArrayCoordinatePoint(new CoordinatePoint[]{
                new CoordinatePoint(1, 5),
                new CoordinatePoint(2, 8),
                new CoordinatePoint(5, 3),
                new CoordinatePoint(8, 9)});
        System.out.println("Длина polyLine: "+ polyLine.getLength(polyLine.getArrayCoordinatePoint()));
        System.out.println("Длина closedPolyLine: "+ closedPolyLine.getLength(closedPolyLine.getArrayCoordinatePoint()));
    }
}