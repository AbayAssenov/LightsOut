package com.abay.assenov.lights_out.model;

import java.util.Objects;

public class CoordinatePoint {
    private Integer x;
    private Integer y;

    public CoordinatePoint(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoordinatePoint)) return false;
        CoordinatePoint that = (CoordinatePoint) o;
        return Objects.equals(getX(), that.getX()) && Objects.equals(getY(), that.getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        return "CoordinatePoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
