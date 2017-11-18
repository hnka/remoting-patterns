package com.hnkalhp.momServer;

import java.io.Serializable;

/**
 * Created by ceciliahunka on 16/11/17.
 */
public class ReplyPacket implements Serializable {

    private Message body;

    public ReplyPacket() {};

    public Message getBody() {
        return body;
    }

    public void setBody(Message body) {
        this.body = body;
    }
}
