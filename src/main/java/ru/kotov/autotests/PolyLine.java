package ru.kotov.autotests;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PolyLine {
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

    public Line[] getLines() {
        if (arrayCoordinatePoint.length != 0 || arrayCoordinatePoint.length != 1) {
            Line[] result = new Line[arrayCoordinatePoint.length - 1];
            for (int i = 0; i < arrayCoordinatePoint.length - 1; i++) {
                result[i] = new Line(arrayCoordinatePoint[i], arrayCoordinatePoint[i + 1]);
            }
            return result;
        } else {
            return new Line[]{};
        }
    }

    public double getLength() {
        Line[] lines = this.getLines();
        if (lines.length != 0) {
            return Arrays.stream(lines)
                    .map(line -> line.getLength())
                    .reduce(Double.valueOf(0), Double::sum);
        } else {
            return 0;
        }
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
}
