package ru.kotov.autotests;

public class ClosedPolyLine extends PolyLine{
    public ClosedPolyLine() {
    }

    public ClosedPolyLine(CoordinatePoint[] arrayCoordinatePoint) {
        super(arrayCoordinatePoint);
    }

    @Override
    public Line[] getLines() {
        CoordinatePoint[] arrayCoordinatePoint = this.getArrayCoordinatePoint();
        int length = arrayCoordinatePoint.length;
        if (length != 0 || length != 1) {
            Line[] result = new Line[length];
            for (int i = 0; i < length - 1; i++) {
                result[i] = new Line(arrayCoordinatePoint[i], arrayCoordinatePoint[i + 1]);
            }
            result[length-1] = new Line(arrayCoordinatePoint[length-1], arrayCoordinatePoint[0]);
            return result;
        } else {
            return new Line[]{};
        }
    }
}
