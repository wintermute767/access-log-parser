package ru.kotov.autotests;

import java.util.Arrays;
import java.util.List;
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

    public Line[] getLines(CoordinatePoint[] coordinatePoints) {
        if (coordinatePoints.length != 0 || coordinatePoints.length != 1) {
            Line[] result = new Line[coordinatePoints.length - 1];
            for (int i = 0; i < coordinatePoints.length - 1; i++) {
                result[i] = new Line(coordinatePoints[i], coordinatePoints[i + 1]);
            }
            return result;
        } else {
            return new Line[]{};
        }
    }

    @Override
    public double getLength(CoordinatePoint[] coordinatePoints) {
        Line[] lines = this.getLines(coordinatePoints);
        double result = 0;
        if (lines.length != 0) {
            for (Line line : lines) {
                result = result + line.getLength(new CoordinatePoint[]{line.getStartCoordinatePoint(), line.getEndCoordinatePoint()});
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
