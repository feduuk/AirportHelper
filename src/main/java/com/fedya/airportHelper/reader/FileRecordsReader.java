package com.fedya.airportHelper.reader;

import com.fedya.airportHelper.Record;

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
    public List<Record> get(int columnNumber){
        List<Record> records = new ArrayList<>();
        try (Scanner scanner = new FileScanner().getScanner(file)) {
            int index = 0;
            while (scanner.hasNextLine()) {
                String content = getRecordFromLine(scanner.nextLine(), columnNumber);
                records.add(new Record(index, content));
                index++;
            }
            return records;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }
    private String getRecordFromLine(String line, int columnNumber) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next().replaceAll("^\"|\"$", ""));
            }
        }
        return values.get(columnNumber-1);
    }
}
