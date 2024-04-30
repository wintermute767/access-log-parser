package ru.сourses.geometry;

public class PolyLine {

    Point[] points;

    public PolyLine(Point... points) {

        this.points = points;

    }

    public double length() {

        double sum = 0, len1, len2;

        for (int i = 0; i < points.length - 1; i++) {

            len1 = points[i].x - points[i - 1].x;

            len2 = points[i].y - points[i - 1].y;

            sum += Math.sqrt(len1 * len1 + len2 * len2);

        }

        return sum;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PolyLine polyLine)) return false;
        if (polyLine.points.length != this.points.length) return false;
        for (int i = 0; i < this.points.length ; i++) {
            if (!this.points[i].equals(polyLine.points[i])) {
                return false;
            }
        }
        return true;
    }
}