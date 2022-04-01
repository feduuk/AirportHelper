package com.fedya.airportHelper.reader;

import com.fedya.airportHelper.Record;

import java.util.List;

public interface RecordsReader {
    List<Record> get(int columnNumber);
}
