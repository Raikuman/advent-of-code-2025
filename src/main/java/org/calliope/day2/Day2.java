package org.calliope.day2;

/*
What's up with this gift shop?

https://adventofcode.com/2025/day/2

The ranges are separated by commas (,); each range gives its first ID and last ID separated by a dash (-).

Since the young Elf was just doing silly patterns, you can find the invalid IDs by looking for any ID which is made only of some sequence of digits repeated twice. So, 55 (5 twice), 6464 (64 twice), and 123123 (123 twice) would all be invalid IDs.

None of the numbers have leading zeroes; 0101 isn't an ID at all. (101 is a valid ID that you would ignore.)

Your job is to find all of the invalid IDs that appear in the given ranges. In the above example:

    11-22 has two invalid IDs, 11 and 22.
    95-115 has one invalid ID, 99.
    998-1012 has one invalid ID, 1010.
    1188511880-1188511890 has one invalid ID, 1188511885.
    222220-222224 has one invalid ID, 222222.
    1698522-1698528 contains no invalid IDs.
    446443-446449 has one invalid ID, 446446.
    38593856-38593862 has one invalid ID, 38593859.
    The rest of the ranges contain no invalid IDs.

Adding up all the invalid IDs in this example produces 1227775554.

What do you get if you add up all of the invalid IDs?
 */

import org.calliope.day2.id.Id;
import org.calliope.resources.FileParser;

import java.io.File;
import java.util.List;

public class Day2 {

    public static void main(String[] args) {
        File testFile = new File("aoc/day2/input.txt");
        List<Id> idList = IdParser.parseIds(FileParser.readByLine(testFile).getFirst());
        System.out.println(idSumPart1(idList));

    }

    public static long idSumPart1(List<Id> idList) {
        long idSum = 0;
        for (Id id : idList) {
            for (long i = id.getFirst(); i <= id.getLast(); i++) {
                // Only look for ids with an even length of characters
                String idString = String.valueOf(i);
                if (idString.length() % 2 != 0) {
                    continue;
                }

                // Split id
                String first = idString.substring(0, idString.length() / 2);
                String last = idString.substring(idString.length() / 2);
                if (first.equals(last)) {
                    idSum += i;
                }
            }
        }

        return idSum;
    }
}
