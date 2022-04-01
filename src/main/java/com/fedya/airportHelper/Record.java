package com.fedya.airportHelper;

public class Record {
    private int index;
    private String recordContent;
    public Record(int index, String recordContent) {
        this.index = index;
        this.recordContent = recordContent;
    }

    public int getIndex() {
        return index;
    }

    public String getRecordContent() {
        return recordContent;
    }

    @Override
    public String toString() {
        return "Record{" +
                "index=" + index +
                ", recordContent='" + recordContent + '\'' +
                '}';
    }


}
