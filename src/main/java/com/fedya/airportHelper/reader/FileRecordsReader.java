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
        try (Scanner scanner = new FileScanner().getScanner(file)) {
            while (scanner.hasNextLine()) {
                records.add(scanner.nextLine());
            }
            return records;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }
    private String getRecordFromLine(String line, int columnNumber) {
        //TODO: use this method because probably forgot and make another branch
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
