package org.calliope.day1.dial;

public class Dial {

    private int position;
    private int numbers;
    private int password = 0;

    public Dial(int position) {
        this.position = position;
        this.numbers = 100;
    }

    public Dial(int position, int numbers) {
        this.position = position;
        this.numbers = numbers;
    }

    public void reset(int position) {
        this.position = position;
        password = 0;
    }

    public void rotate(Rotation rotation) {
        password += Math.abs(rotation.getAmount()) / numbers;
        int normalizedAmount = rotation.getAmount() % numbers;

        int initialPosition = position;

        // Add rotation
        position += normalizedAmount;

        // Handle overflow
        if (position < 0) {
            // Check if initial position was 0
            if (initialPosition != 0) {
                // Going pass 0, +1 password
                password++;
            }

            // Normalize position
            position += numbers * (((position * -1) / numbers) + 1);
        } else if (position > numbers - 1) {
            password++;
            position -= numbers;
        } else if (position == 0) {
            password++;
        }
    }

    public void rotatePart1(Rotation rotation) {
        // Add rotation
        position += rotation.getAmount();

        // Handle overflow
        if (position < 0) {
            position += numbers;
        } else if (position > 99) {
            position -= numbers;
        }
        position %= numbers;

        // Check if current position is 0
        if (position == 0) {
            password++;
        }
    }

    public int getPosition() {
        return position;
    }

    public int getPassword() {
        return password;
    }
}
