package ru.kotov.autotests;

import java.util.Objects;

import static java.lang.Math.sqrt;

public class Line implements Measurable {
    private CoordinatePoint startCoordinatePoint;
    private CoordinatePoint endCoordinatePoint;

    public Line(CoordinatePoint startCoordinatePoint, CoordinatePoint endCoordinatePoint) {
        this.startCoordinatePoint = startCoordinatePoint;
        this.endCoordinatePoint = endCoordinatePoint;
    }

    public Line(int startCoordinateX, int startCoordinateY, int endCoordinateX, int endCoordinateY) {
        this.startCoordinatePoint = new CoordinatePoint(startCoordinateX, startCoordinateY);
        this.endCoordinatePoint = new CoordinatePoint(endCoordinateX, endCoordinateY);
    }

    @Override
    public Line[] getLines() {
        return new Line[]{this};
    }

    @Override
    public double getLength() {
        return sqrt((startCoordinatePoint.getCoordinateX() - endCoordinatePoint.getCoordinateX()) * (startCoordinatePoint.getCoordinateX() - endCoordinatePoint.getCoordinateX())
                + (startCoordinatePoint.getCoordinateY() - endCoordinatePoint.getCoordinateY()) * (startCoordinatePoint.getCoordinateY() - endCoordinatePoint.getCoordinateY()));
    }

    public CoordinatePoint getStartCoordinatePoint() {
        return startCoordinatePoint;
    }

    public CoordinatePoint getEndCoordinatePoint() {
        return endCoordinatePoint;
    }

    public void setStartCoordinatePoint(CoordinatePoint startCoordinatePoint) {
        this.startCoordinatePoint = startCoordinatePoint;
    }

    public void setEndCoordinatePoint(CoordinatePoint endCoordinatePoint) {
        this.endCoordinatePoint = endCoordinatePoint;
    }

    @Override
    public String toString() {
        return "Линия от " + startCoordinatePoint.toString() + " до " + endCoordinatePoint.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line line)) return false;
        return Objects.equals(getStartCoordinatePoint(), line.getStartCoordinatePoint()) && Objects.equals(getEndCoordinatePoint(), line.getEndCoordinatePoint());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStartCoordinatePoint(), getEndCoordinatePoint());
    }
}
