package com.fedya.airportHelper.search;

import com.fedya.airportHelper.Record;

import java.util.List;

public interface RecordsSearcher {
    List<Integer> search(List<Record> records, String lineForSearch);

}
