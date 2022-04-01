package com.fedya.airportHelper.writer;

import com.fedya.airportHelper.Record;
import com.fedya.airportHelper.reader.FileScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortedConsoleRecordsWriter implements RecordsWriter{
    String file;

    public SortedConsoleRecordsWriter(String file) {
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
//        List<String> foundLines = new ArrayList<>();
//        try (Scanner scanner = new FileScanner().getScanner(file)) {
//            int index = 0;
//            while (scanner.hasNextLine()) {
//                if (indexes.contains(index)) {
//                    System.out.println(scanner.nextLine());
//                } else {
//                    scanner.nextLine();
//                }
//                index++;
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
