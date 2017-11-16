package com.hnkalhp.momServer;

/**
 * Created by ceciliahunka on 16/11/17.
 */
public class RequestPacket {

    private RequestPacketHeader packetHeader;
    private RequestPacketBody packetBody;

    public RequestPacket() {};

    public RequestPacketHeader getPacketHeader() {
        return packetHeader;
    }

    public void setPacketHeader(RequestPacketHeader packetHeader) {
        this.packetHeader = packetHeader;
    }

    public RequestPacketBody getPacketBody() {
        return packetBody;
    }

    public void setPacketBody(RequestPacketBody packetBody) {
        this.packetBody = packetBody;
    }
}
