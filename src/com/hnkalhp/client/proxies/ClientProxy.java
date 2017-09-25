package com.hnkalhp.client.proxies;

import java.io.Serializable;
import java.net.UnknownHostException;

/**
 * Created by ceciliahunka on 24/09/17.
 */
public class ClientProxy implements Serializable {

    //private static final long serialVersionUID = 1L;
    protected String hostName;
    protected int portNumber;
    protected int objectId;

    public ClientProxy () {}

    public ClientProxy (String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

}
