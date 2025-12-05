package org.calliope.day1.dial;

import org.calliope.resources.FileParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

class DialTest {

    @Test
    @DisplayName("Dial Test Example Input")
    void testDialExampleInput() {
        File testFile = new File("aoc/day1/test1.txt");
        List<Rotation> rotationList = RotationParser.parseRotations(FileParser.readByLine(testFile));
        Dial dial = new Dial(50);
        for  (Rotation rotation : rotationList) {
            dial.rotatePart1(rotation);
        }

        Assertions.assertEquals(3, dial.getPassword());
    }

    @Test
    @DisplayName("Dial Test Large Rotation")
    void testDialLargeRotation() {
        File testFile = new File("aoc/day1/test2.txt");
        List<Rotation> rotationList = RotationParser.parseRotations(FileParser.readByLine(testFile));
        Dial dial = new Dial(50);
        for  (Rotation rotation : rotationList) {
            dial.rotatePart1(rotation);
        }

        Assertions.assertEquals(2, dial.getPassword());
    }

    @Test
    @DisplayName("Dial Test Increment On Full Rotation")
    void testDialFullRotation() {
        File testFile = new File("aoc/day1/test1.txt");
        List<Rotation> rotationList = RotationParser.parseRotations(FileParser.readByLine(testFile));
        Dial dial = new Dial(50);
        for  (Rotation rotation : rotationList) {
            dial.rotate(rotation);
        }

        Assertions.assertEquals(6, dial.getPassword());
    }

    @Test
    @DisplayName("Dial Test Increment On Full Large Rotation")
    void testDialFullLargeRotation() {
        File testFile = new File("aoc/day1/test2.txt");
        List<Rotation> rotationList = RotationParser.parseRotations(FileParser.readByLine(testFile));
        Dial dial = new Dial(50);
        for  (Rotation rotation : rotationList) {
            dial.rotate(rotation);
        }

        Assertions.assertEquals(5, dial.getPassword());
    }
}