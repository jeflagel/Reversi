package com.progression.model;

public class Direction {
    int x;
    int y;
    int retournement;

    public Direction(int x, int y, int retournement) {
        this.x = x;
        this.y = y;
        this.retournement = retournement;
    }

    public int getRetournement() {
        return retournement;
    }

    public void setRetournement(int retournement) {
        this.retournement = retournement;
    }

    public Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
