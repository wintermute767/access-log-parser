package ru.сourses.geometry;

public class Line implements Cloneable {
    Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Line line)) return false;
        return start.equals(line.start) && end.equals(line.end);
    }

    @Override
    public Line clone() {
        Point newStart = this.start.clone();
        Point newEnd = this.end.clone();
        return new Line(newStart, newEnd);
    }
}