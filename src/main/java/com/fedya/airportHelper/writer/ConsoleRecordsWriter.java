package com.fedya.airportHelper.writer;

import com.fedya.airportHelper.reader.FileScanner;

import java.util.*;

public class ConsoleRecordsWriter implements RecordsWriter{
    String file;

    public ConsoleRecordsWriter(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
    @Override
    public void write(List<String> records){
        String[] fullRecords = new String[records.size()];

        try (Scanner scanner = new FileScanner().getScanner(file)) {
            while (scanner.hasNextLine()) {
                if (records.contains(index)) {

                    fullRecords[] = scanner.nextLine();
                } else {
                    scanner.nextLine();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
