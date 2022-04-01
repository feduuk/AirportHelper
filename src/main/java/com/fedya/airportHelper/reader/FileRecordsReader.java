package com.fedya.airportHelper.reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileRecordsReader implements RecordsReader {
    String file;

    public FileRecordsReader(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public List<String> get(int columnNumber){
        List<String> records = new ArrayList<>();
        ColumnReader columnReader = new ColumnReader();
        try (Scanner scanner = new FileScanner().getScanner(file)) {
            while (scanner.hasNextLine()) {
                records.add(columnReader.getRecordFromLine(scanner.nextLine(), columnNumber));
            }
            return records;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }
}
