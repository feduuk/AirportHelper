package com.fedya.airportHelper;

import java.util.Comparator;

public class RecordComparator implements Comparator<Record> {
    @Override
    public int compare(Record o1, Record o2) {
        return o1.getRecordContent().compareTo(o2.getRecordContent());
    }
}
