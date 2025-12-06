package org.calliope.day3;

import org.calliope.resources.FileParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

class Day3Test {

    @Test
    @DisplayName("Joltage Total Output")
    void testJoltageTotalOutput() {
        File testFile = new File("aoc/day3/test1.txt");
        Assertions.assertEquals(357, Day3.largestJoltagePart1(FileParser.readByLine(testFile)));
    }
}
