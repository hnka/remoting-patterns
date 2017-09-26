package com.hnkalhp.namingServer;

import java.util.ArrayList;

/**
 * Created by ceciliahunka on 26/09/17.
 */
public class NamingRepository {

    private ArrayList<NamingRecord> namingRecords;

    public NamingRepository () {
        this.namingRecords = new ArrayList<>();
    }

    public void setNamingRecord(NamingRecord record) {
        this.namingRecords.add(record);
    }

    public NamingRecord findNamingRecord(String name) {
        NamingRecord foundRecord = null;
        for (int i = 0; i < this.namingRecords.size(); i++) {
            if (this.namingRecords.get(i).getServiceName().equals(name)) {
                foundRecord = this.namingRecords.get(i);
            }
        }

        return foundRecord;
    }

    public ArrayList<String> getAllNamingRecords () {
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < this.namingRecords.size(); i++) {
            names.add(this.namingRecords.get(i).getServiceName());
        }
        return names;
    }

}
