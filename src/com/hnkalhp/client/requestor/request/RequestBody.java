package com.hnkalhp.client.requestor.request;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ceciliahunka on 24/09/17.
 */
public class RequestBody implements Serializable {
    private ArrayList<Object> parameters;

    public RequestBody(ArrayList<Object> parameters) {
        this.parameters = parameters;
    }

    public ArrayList<Object> getParameters() {
        return parameters;
    }
}
