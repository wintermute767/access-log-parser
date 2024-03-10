package ru.сourses.geometry;

public class ClosedPolyLine extends PolyLine{
    @Override
    public Line[] getLines(CoordinatePoint[] coordinatePoints) {
        int length = coordinatePoints.length;
        if (length != 0 || length != 1) {
            Line[] result = new Line[length];
            for (int i = 0; i < length - 1; i++) {
                result[i] = new Line(coordinatePoints[i], coordinatePoints[i + 1]);
            }
            result[length-1] = new Line(coordinatePoints[length-1], coordinatePoints[0]);
            return result;
        } else {
            return new Line[]{};
        }
    }
}
