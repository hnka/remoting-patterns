package com.hnkalhp.namingServer;

import com.hnkalhp.client.proxies.ClientProxy;

/**
 * Created by ceciliahunka on 26/09/17.
 */
public class NamingRecord {

    private String serviceName;
    private ClientProxy clientProxy;

    public NamingRecord(String serviceName, ClientProxy clientProxy) {
        this.serviceName = serviceName;
        this.clientProxy = clientProxy;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public ClientProxy getClientProxy() {
        return clientProxy;
    }

    public void setClientProxy(ClientProxy clientProxy) {
        this.clientProxy = clientProxy;
    }

}
