package ru.сourses.geometry;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PolyLine implements Measurable {
    private CoordinatePoint[] arrayCoordinatePoint;

    public PolyLine() {
    }

    public PolyLine(CoordinatePoint[] arrayCoordinatePoint) {
        this.arrayCoordinatePoint = arrayCoordinatePoint;
    }

    @Override
    public String toString() {
        return "Линия [" + Arrays
                .stream(arrayCoordinatePoint)
                .map(coordinatePoint -> coordinatePoint.toString())
                .collect(Collectors.joining(" ,")) + "]";
    }

    public CustomLine[] getLines(CoordinatePoint[] coordinatePoints) {
        if (coordinatePoints.length != 0 || coordinatePoints.length != 1) {
            CustomLine[] result = new CustomLine[coordinatePoints.length - 1];
            for (int i = 0; i < coordinatePoints.length - 1; i++) {
                result[i] = new CustomLine(coordinatePoints[i], coordinatePoints[i + 1]);
            }
            return result;
        } else {
            return new CustomLine[]{};
        }
    }

    @Override
    public double getLength(CoordinatePoint[] coordinatePoints) {
        CustomLine[] customLines = this.getLines(coordinatePoints);
        double result = 0;
        if (customLines.length != 0) {
            for (CustomLine customLine : customLines) {
                result = result + customLine.getLength(new CoordinatePoint[]{customLine.getStartCoordinatePoint(), customLine.getEndCoordinatePoint()});
            }
        }
        return result;
    }

    public void setArrayCoordinatePoint(CoordinatePoint[] arrayCoordinatePoint) {
        this.arrayCoordinatePoint = arrayCoordinatePoint;
    }

    public void changeCoordinatePoint(int position, CoordinatePoint coordinatePoint) {
        if (position <= arrayCoordinatePoint.length) {
            arrayCoordinatePoint[position] = coordinatePoint;
        } else {
            System.out.println("Изменения не прошло - позиция точки не совпадает с длиной массива");
        }
    }

    public CoordinatePoint[] getArrayCoordinatePoint() {
        return arrayCoordinatePoint;
    }
}
