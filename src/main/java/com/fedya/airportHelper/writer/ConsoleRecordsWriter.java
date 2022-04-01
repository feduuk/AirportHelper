package com.fedya.airportHelper.writer;

import com.fedya.airportHelper.reader.ColumnReader;
import com.fedya.airportHelper.reader.FileScanner;

import java.util.*;

public class ConsoleRecordsWriter implements RecordsWriter{
    private final int columnNumber;
    private String file;

    public ConsoleRecordsWriter(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public ConsoleRecordsWriter(String file, int columnNumber) {
        this.file = file;
        this.columnNumber = columnNumber;
    }

    @Override
    public void write(List<String> records){
        String[] fullRecords = new String[records.size()];

        try (Scanner scanner = new FileScanner().getScanner(file)) {
            ColumnReader columnReader = new ColumnReader();
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                String column = columnReader.getRecordFromLine(row, columnNumber);
                int index = records.indexOf(column);
                if (index != -1) {
                    fullRecords[index] = row;
                }
            }
            for(int i = 0; i < records.size(); i++){
                System.out.println(records.get(i) + " : " + fullRecords[i]);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
