package com.github.klefstad_teaching.cs122b.basic.request;

public class MathRequest {

    private Integer numX = null;
    private Integer numY = null;
    private Integer numZ = null;

    public Integer getNumX() {
        return numX;
    }

    public MathRequest setNumX(Integer numX) {
        this.numX = numX;
        return this;
    }

    public Integer getNumY() {
        return numY;
    }

    public MathRequest setNumY(Integer numY) {
        this.numY = numY;
        return this;
    }

    public Integer getNumZ() {
        return numZ;
    }

    public MathRequest setNumZ(Integer numZ) {
        this.numZ = numZ;
        return this;
    }

    public Integer getValue() {
        return (numX * numY) + numZ;
    }

    public boolean allNumbersSet() {
        return numX != null && numY != null && numZ != null;
    }

    public boolean xInBounds() {
        return numX > 0 && numX < 100;
    }

    public boolean yInBounds() {
        return numY > 0 && numY < 100;
    }

    public boolean zInBounds() {
        return numZ >= -10 && numZ <= 10;
    }
}
