package org.calliope.day1.dial;

public class Dial {

    private int position;
    private int numbers;

    public Dial(int position) {
        this.position = position;
        this.numbers = 100;
    }

    public Dial(int position, int numbers) {
        this.position = position;
        this.numbers = numbers;
    }

    public void rotate(Rotation rotation) {
        // Add rotation
        position += rotation.getAmount();

        // Handle overflow
        if (position < 0) {
            position += numbers;
        } else if (position > 99) {
            position -= numbers;
        }
    }
}
