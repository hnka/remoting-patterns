package com.hnkalhp.momServer;

import java.io.Serializable;

/**
 * Created by ceciliahunka on 16/11/17.
 */
public class Message implements Serializable {

    private MessageHeader header;
    private MessageBody body;

    public Message() {};

    public MessageHeader getHeader() {
        return header;
    }

    public void setHeader(MessageHeader header) {
        this.header = header;
    }

    public MessageBody getBody() {
        return body;
    }

    public void setBody(MessageBody body) {
        this.body = body;
    }
}
