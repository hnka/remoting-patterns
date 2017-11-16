package com.hnkalhp.momServer;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ceciliahunka on 16/11/17.
 */
public class QueueManagerProxy implements IQueueManager {

    private String queueName = null;

    public QueueManagerProxy(String queueName) {
        this.queueName = queueName;
    }

    public void send(String m) throws IOException, InterruptedException {

        ClientRequestHandler handler = new ClientRequestHandler("localhost", 1313);
        Marshaller marshaller = new Marshaller();
        RequestPacket packet = new RequestPacket();
        Message message = new Message();

        message.setHeader(new MessageHeader(this.queueName));
        message.setBody(new MessageBody(m));

        RequestPacketBody packetBody = new RequestPacketBody();
        ArrayList<Object> parameters = new ArrayList<Object>(0);

        packetBody.setParameters(parameters);
        packetBody.setMessage(message);
        packet.setPacketHeader(new RequestPacketHeader("send"));
        packet.setPacketBody(packetBody);

        Object packetObj = (Object) packet;
        handler.send(marshaller.marshall(packetObj));

    }

    public String receive() throws IOException, InterruptedException {
        // finish implementation
        return "";
    }
}
