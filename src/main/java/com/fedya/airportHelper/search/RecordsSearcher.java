package com.fedya.airportHelper.search;

import java.util.List;

public interface RecordsSearcher {
    List<String> search(List<String> records, String lineForSearch);

}
