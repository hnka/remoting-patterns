package com.hnkalhp.momServer;

/**
 * Created by ceciliahunka on 16/11/17.
 */
public class RequestPacketHeader {

    private String operation;

    public RequestPacketHeader(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
