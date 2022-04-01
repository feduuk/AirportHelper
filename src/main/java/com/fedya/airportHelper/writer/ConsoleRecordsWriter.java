package com.fedya.airportHelper.writer;

import com.fedya.airportHelper.reader.FileScanner;

import java.util.List;
import java.util.Scanner;

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
    public void write(List<Integer> indexes){
        try (Scanner scanner = new FileScanner().getScanner(file)) {
            int index = 0;
            while (scanner.hasNextLine()) {
                if(indexes.contains(index)){
                    System.out.println(scanner.nextLine());
                }else{
                    scanner.nextLine();
                }
                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
