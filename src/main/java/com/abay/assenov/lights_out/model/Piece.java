package com.abay.assenov.lights_out.model;

import java.util.Arrays;

public class Piece {
    private String[][] parts;

    public Piece(String[][] parts) {
        this.parts = parts;
    }

    public String[][] getParts() {
        return parts;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "parts=" + Arrays.toString(parts) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Piece)) return false;
        Piece piece = (Piece) o;
        return Arrays.equals(getParts(), piece.getParts());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getParts());
    }
}
