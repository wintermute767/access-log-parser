package ru.kotov.autotests;

public class ClosedPolyLine extends PolyLine{
    @Override
    public Line[] getLines() {
        int length = super.getArrayCoordinatePoint().length;
        if (length != 0 || length != 1) {
            Line[] result = new Line[length];
            for (int i = 0; i < length - 1; i++) {
                result[i] = new Line(super.getArrayCoordinatePoint()[i], super.getArrayCoordinatePoint()[i + 1]);
            }
            result[length-1] = new Line(super.getArrayCoordinatePoint()[length-1], super.getArrayCoordinatePoint()[0]);
            return result;
        } else {
            return new Line[]{};
        }
    }
}
