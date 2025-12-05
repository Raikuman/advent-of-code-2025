package org.calliope.day1.dial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RotationParser {

    public static List<Rotation> parseRotations(List<String> rotationInput) {
        List<Rotation> rotations = new ArrayList<>();

        for (String s : rotationInput) {
            s = s.toLowerCase();

            // Get rotation direction
            boolean clockwise;
            switch (s.charAt(0)) {
                case 'l':
                    clockwise = false;
                    break;
                case 'r':
                    clockwise = true;
                    break;
                default:
                    System.out.println("Malformed rotation input: " + s);
                    return Collections.emptyList();
            }

            // Remove rotation direction character
            s = s.substring(1);

            // Check rotation amount
            try {
                int amount = Integer.parseInt(s);
                rotations.add(new Rotation(clockwise, amount));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format: " + s);
                return Collections.emptyList();
            }
        }

        return rotations;
    }

}
