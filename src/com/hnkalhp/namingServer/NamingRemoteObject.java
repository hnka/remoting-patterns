package com.hnkalhp.namingServer;

import com.hnkalhp.client.proxies.ClientProxy;

import java.util.ArrayList;

/**
 * Created by ceciliahunka on 26/09/17.
 */
public class NamingRemoteObject {

    private NamingRepository namingRepository;

    public NamingRemoteObject(NamingRepository namingRepository) {
        this.namingRepository = namingRepository;
    }

    public void bind(String serviceName, ClientProxy clientProxy) throws Exception {
        NamingRecord record = new NamingRecord(serviceName, clientProxy);
        this.namingRepository.setNamingRecord(record);
    }

    public ClientProxy lookup(String name) throws Exception {
        NamingRecord namingRecord = this.namingRepository.findNamingRecord(name);
        return namingRecord.getClientProxy();
    }

    public ArrayList<String> list() throws Exception {
        return this.namingRepository.getAllNamingRecords();
    }

}
