package com.hnkalhp.momServer;

import java.util.ArrayList;

/**
 * Created by ceciliahunka on 16/11/17.
 */
public class RequestPacketBody {

    private ArrayList<Object> parameters = new ArrayList<Object>();
    private Message message;

    public RequestPacketBody() {};

    public ArrayList<Object> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Object> parameters) {
        this.parameters = parameters;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
