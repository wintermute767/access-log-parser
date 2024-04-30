package ru.сourses.geometry;

public class ClosedPolyLine extends PolyLine{
    @Override
    public CustomLine[] getLines(CoordinatePoint[] coordinatePoints) {
        int length = coordinatePoints.length;
        if (length != 0 || length != 1) {
            CustomLine[] result = new CustomLine[length];
            for (int i = 0; i < length - 1; i++) {
                result[i] = new CustomLine(coordinatePoints[i], coordinatePoints[i + 1]);
            }
            result[length-1] = new CustomLine(coordinatePoints[length-1], coordinatePoints[0]);
            return result;
        } else {
            return new CustomLine[]{};
        }
    }
}
