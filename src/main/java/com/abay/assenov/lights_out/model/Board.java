package com.abay.assenov.lights_out.model;

import java.util.Arrays;

public class Board {
    private Integer[][] positions;

    public Board(Integer[][] positions) {
        this.positions = positions;
    }

    public Integer[][] getPositions() {
        return positions;
    }

    @Override
    public String toString() {
        return "Board{" +
                "positions=" + Arrays.toString(positions) +
                '}';
    }
}
