package com.fedya.airportHelper.search;

import com.fedya.airportHelper.Record;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryRecordsSearcher implements RecordsSearcher {
    @Override
    public List<Integer> search(List<Record> records, String lineForSearch) {
        List<Integer> indexes = new ArrayList<>();
        if(lineForSearch == null) return indexes;
        Record dummyRecord = new Record(-1, lineForSearch);
        int indexOfFoundRecord = Collections.binarySearch(records, dummyRecord, (o1, o2) -> {
            String content1 = o1.getRecordContent();
            String content2 = o2.getRecordContent();
            return content1.substring(0, Math.min(content2.length(), content1.length())).compareTo(content2);
        });
        if(indexOfFoundRecord >= 0) {
            indexes.add(records.get(indexOfFoundRecord).getIndex());
            for (int indexUp = indexOfFoundRecord + 1; indexUp < records.size(); indexUp++) {
                if (records.get(indexUp).getRecordContent().startsWith(lineForSearch)) {
                    indexes.add(records.get(indexUp).getIndex());
                } else {
                    break;
                }
            }
            for (int indexDown = indexOfFoundRecord - 1; indexDown >= 0 ; indexDown--) {
                if (records.get(indexDown).getRecordContent().startsWith(lineForSearch)) {
                    indexes.add(records.get(indexDown).getIndex());
                } else {
                    break;
                }
            }
        }
        return indexes;
    }
}
