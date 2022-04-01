package com.fedya.airportHelper.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryRecordsSearcher implements RecordsSearcher {
    @Override
    public List<String> search(List<String> records, String lineForSearch) {
        List<String> foundRecords = new ArrayList<>();
        if(lineForSearch == null) return foundRecords;
        int indexOfFoundRecord = Collections.binarySearch(records, lineForSearch,
                (o1, o2) -> o1.substring(0, Math.min(o2.length(), o1.length())).compareTo(o2));
        if(indexOfFoundRecord >= 0) {
            foundRecords.add(records.get(indexOfFoundRecord));
            for (int indexUp = indexOfFoundRecord + 1; indexUp < records.size(); indexUp++) {
                if (records.get(indexUp).startsWith(lineForSearch)) {
                    foundRecords.add(records.get(indexUp));
                } else {
                    break;
                }
            }
            for (int indexDown = indexOfFoundRecord - 1; indexDown >= 0 ; indexDown--) {
                if (records.get(indexDown).startsWith(lineForSearch)) {
                    foundRecords.add(records.get(indexDown));
                } else {
                    break;
                }
            }
        }
        return foundRecords;
    }
}
