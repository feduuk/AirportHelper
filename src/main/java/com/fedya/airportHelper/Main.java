package com.fedya.airportHelper;

import com.fedya.airportHelper.column.ColumnNumberImpl;
import com.fedya.airportHelper.reader.FileRecordsReader;
import com.fedya.airportHelper.reader.RecordsReader;
import com.fedya.airportHelper.search.BinaryRecordsSearcher;
import com.fedya.airportHelper.search.RecordsSearcher;
import com.fedya.airportHelper.writer.ConsoleRecordsWriter;
import com.fedya.airportHelper.writer.RecordsWriter;
import com.fedya.airportHelper.writer.SortedConsoleRecordsWriter;

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
        List<Record> records = recordsReader.get(columnNumber);
        if(records != null && records.size() > 0) {
            RecordComparator recordComparator = new RecordComparator();
            Collections.sort(records, recordComparator);

            RecordsSearcher recordsSearcher = new BinaryRecordsSearcher();
            long startTime = System.currentTimeMillis();
            List<Integer> indexes = recordsSearcher.search(records, lineForSearch);
            long endTime = System.currentTimeMillis();
            long searchingTime = endTime - startTime;


            RecordsWriter recordsWriter = new SortedConsoleRecordsWriter(fileName);
            recordsWriter.write(indexes);
            System.out.println("\nNumber of found lines: " + indexes.size());
            System.out.println("Searching took " + searchingTime + " milliseconds");
        }else {
            System.out.println("There is no lines!");
        }
    }
}
