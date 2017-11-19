package com.hnkalhp.momServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ceciliahunka on 18/11/17.
 */
public class QueueInvoker {

    public QueueInvoker() {};

    public void invoke(QueueManager queueManager, int port) throws IOException, ClassNotFoundException {

        System.out.println("Starting server...");

        ServerRequestReader requestReader = new ServerRequestReader(port);

        byte[] messageToBeUnmarshalled = null;
        byte[] messageMarshalled = null;
        RequestPacket messageUnmarshalled = new RequestPacket();

        Marshaller marshaller = new Marshaller();

        while (true) {
            ServerRequestHandler requestHandler = requestReader.accept();
            messageToBeUnmarshalled = requestHandler.receive();
            messageUnmarshalled = (RequestPacket) marshaller.unmarshall(messageToBeUnmarshalled);

            switch (messageUnmarshalled.getPacketHeader().getOperation()) {
                case "send":
                    System.out.println("New SEND REQUEST");
                    Message message = messageUnmarshalled.getPacketBody().getMessage();
                    String queueName = message.getHeader().getDestination();

                    Queue queue = queueManager.getQueue(queueName);
                    queue.enqueue(message);
                    break;
                case "receive":
                    System.out.println("New RECEIVE REQUEST");
                    RequestPacketBody packetBody =  messageUnmarshalled.getPacketBody();
                    Message receiveMessage = packetBody.getMessage();

                    String queueNameReceive = receiveMessage.getHeader().getDestination();

                    Queue queueReceive = queueManager.getQueue(queueNameReceive);
                    QueueServerThread queueThread = new QueueServerThread(requestHandler, queueReceive);

                    Thread t = new Thread(queueThread);
                    t.start();
                    break;
                default:
                    System.out.println("Not a suitable method. Try again.");
                    break;
            }

        }

    }

}
