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

    // stores messages on queue
    public void send(String m) throws IOException, InterruptedException {

        ClientRequestHandler handler = new ClientRequestHandler("localhost", 3000);
        handler.setExpectedReply(false);
        Marshaller marshaller = new Marshaller();
        RequestPacket packet = new RequestPacket();
        Message message = new Message();

        // queue name on message header
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

    // retrieve messages on queue
    public String receive(int index) throws IOException, InterruptedException, ClassNotFoundException {
        // finish implementation
        // client request handler send + receive

        ClientRequestHandler handler = new ClientRequestHandler("localhost", 3000);
        handler.setExpectedReply(true);

        Marshaller marshaller = new Marshaller();
        RequestPacket packet = new RequestPacket();
        Message message = new Message();

        message.setHeader(new MessageHeader(this.queueName));
        message.setBody(new MessageBody(""));

        RequestPacketBody packetBody = new RequestPacketBody();
        ArrayList<Object> parameters = new ArrayList<Object>(0);
        parameters.add(index);

        packetBody.setParameters(parameters);
        packetBody.setMessage(message);
        packet.setPacketHeader(new RequestPacketHeader("receive"));
        packet.setPacketBody(packetBody);

        Object packetObj = (Object) packet;
        handler.send(marshaller.marshall(packetObj));

        byte[] response = handler.receive();
        ReplyPacket messageUnmarshalled = (ReplyPacket) marshaller.unmarshall(response);

        return messageUnmarshalled.getBody().getBody().getBody();
    }


    public void addListener(ISubscriber subscriber) throws IOException, InterruptedException, ClassNotFoundException {

        ClientRequestHandler handler = new ClientRequestHandler("localhost", 3000);
        handler.setExpectedReply(true);
        Marshaller marshaller = new Marshaller();
        RequestPacket packet = new RequestPacket();
        Message message = new Message();

        // queue name on message header
        message.setHeader(new MessageHeader(this.queueName));
        message.setBody(new MessageBody(""));

        RequestPacketBody packetBody = new RequestPacketBody();
        ArrayList<Object> parameters = new ArrayList<Object>(0);
        parameters.add(subscriber);

        packetBody.setParameters(parameters);
        packetBody.setMessage(message);
        packet.setPacketHeader(new RequestPacketHeader("add"));
        packet.setPacketBody(packetBody);

        Object packetObj = (Object) packet;
        handler.send(marshaller.marshall(packetObj));
    }

}
