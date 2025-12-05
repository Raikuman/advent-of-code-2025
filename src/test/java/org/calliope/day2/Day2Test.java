package org.calliope.day2;

import org.calliope.day2.id.Id;
import org.calliope.resources.FileParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

class Day2Test {

    @Test
    @DisplayName("Id Test Example Input")
    void textIdExampleInput() {
        File testFile = new File("aoc/day2/test1.txt");
        List<Id> idList = IdParser.parseIds(FileParser.readByLine(testFile).getFirst());
        Assertions.assertEquals(1227775554, Day2.idSumPart1(idList));
    }
}