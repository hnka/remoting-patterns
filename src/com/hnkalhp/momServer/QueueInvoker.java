package com.hnkalhp.momServer;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by ceciliahunka on 18/11/17.
 */
public class QueueInvoker {

    public QueueInvoker() {};

    public void invoke(QueueManager queueManager, int port) throws IOException, ClassNotFoundException {

        ServerRequestReader requestReader = new ServerRequestReader(port);

        byte[] messageToBeUnmarshalled = null;
        byte[] messageMarshalled = null;
        RequestPacket messageUnmarshalled = new RequestPacket();

        Marshaller marshaller = new Marshaller();

        while (true) {
            ServerRequestHandler requestHandler = requestReader.accept();
            messageToBeUnmarshalled = requestHandler.receive();
            messageUnmarshalled = (RequestPacket) marshaller.unmarshall(messageToBeUnmarshalled);

            System.out.println(messageUnmarshalled.getPacketHeader().getOperation());

            switch (messageUnmarshalled.getPacketHeader().getOperation()) {
                case "send":
                    Message message = messageUnmarshalled.getPacketBody().getMessage();
                    String queueName = message.getHeader().getDestination();

                    Queue queue = queueManager.getQueue(queueName);
                    queue.enqueue(message);
                    break;
                case "receive":
                    RequestPacketBody packetBody =  messageUnmarshalled.getPacketBody();
                    Message receiveMessage = packetBody.getMessage();
                    int index = (int) packetBody.getParameters().get(0);

                    String queueNameReceive = receiveMessage.getHeader().getDestination();

                    Queue queueReceive = queueManager.getQueue(queueNameReceive);
                    Message messageToSend = queueReceive.dequeue(index);

                    ReplyPacket packet = new ReplyPacket();
                    packet.setBody(messageToSend);

                    messageMarshalled = marshaller.marshall(packet);
                    requestHandler.send(messageMarshalled);
                    break;
                case "add":
                    RequestPacketBody addPacketBody =  messageUnmarshalled.getPacketBody();
                    Message addReceiveMessage = addPacketBody.getMessage();
                    ISubscriber listener = (ISubscriber) addPacketBody.getParameters().get(0);

                    String queueNameAdd = addReceiveMessage.getHeader().getDestination();
                    Queue addQueue = queueManager.getQueue(queueNameAdd);
                    addQueue.addListener(listener);
                    break;
                default:
                    System.out.println("Not a suitable method. Try again.");
                    break;
            }

        }

    }

}
