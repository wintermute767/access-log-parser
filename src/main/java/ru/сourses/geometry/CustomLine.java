package ru.сourses.geometry;

import java.util.Objects;

import static java.lang.Math.sqrt;

public class CustomLine implements Measurable {
    private CoordinatePoint startCoordinatePoint;
    private CoordinatePoint endCoordinatePoint;

    public CustomLine(CoordinatePoint startCoordinatePoint, CoordinatePoint endCoordinatePoint) {
        this.startCoordinatePoint = startCoordinatePoint;
        this.endCoordinatePoint = endCoordinatePoint;
    }

    public CustomLine(int startCoordinateX, int startCoordinateY, int endCoordinateX, int endCoordinateY) {
        this.startCoordinatePoint = new CoordinatePoint(startCoordinateX, startCoordinateY);
        this.endCoordinatePoint = new CoordinatePoint(endCoordinateX, endCoordinateY);
    }

    @Override
    public double getLength(CoordinatePoint[] coordinatePoints) {
        return sqrt((coordinatePoints[0].getCoordinateX() - coordinatePoints[1].getCoordinateX()) * (coordinatePoints[0].getCoordinateX() - coordinatePoints[1].getCoordinateX())
                + (coordinatePoints[0].getCoordinateY() - coordinatePoints[1].getCoordinateY()) * (coordinatePoints[0].getCoordinateY() - coordinatePoints[1].getCoordinateY()));
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
        if (!(o instanceof CustomLine customLine)) return false;
        return Objects.equals(getStartCoordinatePoint(), customLine.getStartCoordinatePoint()) && Objects.equals(getEndCoordinatePoint(), customLine.getEndCoordinatePoint());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStartCoordinatePoint(), getEndCoordinatePoint());
    }
}
