package com.fedya.airportHelper.reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ColumnReader {
    public String getRecordFromLine(String line, int columnNumber) throws Exception {

        if(line == null) throw new Exception("String can't be null!");
        if(columnNumber <= 0) throw new Exception("columnNumber has to be positive!");
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next().replaceAll("^\"|\"$", ""));
            }
        }
        if((columnNumber - 1) > (values.size() - 1)) throw new Exception("columnNumber has to be present!");
        return values.get(columnNumber-1);
    }
}
