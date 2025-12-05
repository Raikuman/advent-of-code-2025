package org.calliope.day1.dial;

public class Rotation {

    private boolean clockwise;
    private int amount;

    public Rotation(boolean clockwise, int amount) {
        this.clockwise = clockwise;
        this.amount = amount;
        if (amount < 0) {
            this.amount *= -1;
        }
    }

    public boolean isClockwise() {
        return clockwise;
    }

    public int getAmount() {
        int rotation = amount;
        if (!clockwise) {
            rotation *= -1;
        }

        return rotation;
    }
}
