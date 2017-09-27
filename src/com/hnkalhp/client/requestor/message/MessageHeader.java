package com.hnkalhp.client.requestor.message;

import java.io.Serializable;

public class MessageHeader implements Serializable {

    private String magic;
    private int version;
    private boolean byteOrder;
    private int messageType;
    private long messageSize;

    public MessageHeader (String magic, int version, boolean byteOrder, int messageType, long messageSize) {
        this.magic = magic;
        this.version = version;
        this.byteOrder = byteOrder;
        this.messageType = messageType;
        this.messageSize = messageSize;
    }

    public String getMagic() {
        return magic;
    }

    public void setMagic(String magic) {
        this.magic = magic;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public boolean isByteOrder() {
        return byteOrder;
    }

    public void setByteOrder(boolean byteOrder) {
        this.byteOrder = byteOrder;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public long getMessageSize() {
        return messageSize;
    }

    public void setMessageSize(long messageSize) {
        this.messageSize = messageSize;
    }

}
