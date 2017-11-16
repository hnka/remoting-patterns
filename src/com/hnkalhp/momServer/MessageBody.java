package com.hnkalhp.momServer;

import java.io.Serializable;

/**
 * Created by ceciliahunka on 16/11/17.
 */
public class MessageBody implements Serializable {

    private String body;

    public MessageBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
