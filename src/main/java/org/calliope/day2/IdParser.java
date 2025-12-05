package org.calliope.day2;

import org.calliope.day2.id.Id;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IdParser {

    public static List<Id> parseIds(String input) {
        List<Id> ids = new ArrayList<>();

        String[] idStrings = input.split(",");
        for (String id : idStrings) {
            id = id.trim();
            String[] foundId = id.split("-");
            if (foundId.length != 2) {
                System.out.println("Malformed id input: " + id);
                return Collections.emptyList();
            }

            try {
                ids.add(new Id(Long.parseLong(foundId[0]), Long.parseLong(foundId[1])));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format: " + id);
                return Collections.emptyList();
            }
        }

        return ids;
    }
}
