package com.fedya.airportHelper.reader;

import java.util.List;

public interface RecordsReader {
    List<String> get(int columnNumber);
}
