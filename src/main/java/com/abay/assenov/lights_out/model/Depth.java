package com.abay.assenov.lights_out.model;

public class Depth {
    private int value;

    public Depth(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Depth{" +
                "value=" + value +
                '}';
    }
}
