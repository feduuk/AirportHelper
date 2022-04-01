package com.fedya.airportHelper;

import com.fedya.airportHelper.column.ColumnNumberImpl;
import com.fedya.airportHelper.reader.FileRecordsReader;
import com.fedya.airportHelper.reader.RecordsReader;
import com.fedya.airportHelper.search.BinaryRecordsSearcher;
import com.fedya.airportHelper.search.RecordsSearcher;
import com.fedya.airportHelper.writer.RecordsWriter;
import com.fedya.airportHelper.writer.ConsoleRecordsWriter;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        String fileName = "airports.dat";
        int columnNumber = new ColumnNumberImpl().getNumber(args);

        Scanner scan = new Scanner(System.in);
        String lineForSearch = null;
        do {
            System.out.println("Enter a line for search: ");
            lineForSearch = scan.nextLine();
        }while(lineForSearch.equals(""));
        RecordsReader recordsReader = new FileRecordsReader(fileName);
        List<String> records = recordsReader.get(columnNumber);
        if(records != null && records.size() > 0) {
            Collections.sort(records);

            RecordsSearcher recordsSearcher = new BinaryRecordsSearcher();
            long startTime = System.currentTimeMillis();
            List<String> foundRecords = recordsSearcher.search(records, lineForSearch);
            long endTime = System.currentTimeMillis();
            long searchingTime = endTime - startTime;


            RecordsWriter recordsWriter = new ConsoleRecordsWriter(fileName, columnNumber);
            recordsWriter.write(foundRecords);
            System.out.println("\nNumber of found lines: " + foundRecords.size());
            System.out.println("Searching took " + searchingTime + " milliseconds");
        }else {
            System.out.println("There is no lines!");
        }
    }
}
