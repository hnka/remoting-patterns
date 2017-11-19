package com.hnkalhp.momServer;

import java.io.IOException;

/**
 * Created by ceciliahunka on 19/11/17.
 */
public class QueueServerThread implements Runnable {

    private ServerRequestHandler handler;
    private Queue queue;
    private int queueSize;

    public QueueServerThread(ServerRequestHandler handler, Queue queue) {
        this.handler = handler;
        this.queue = queue;
        this.queueSize = queue.getSize();
    }

    public void run() {
        synchronized (this.queue) {

            Marshaller marshaller = new Marshaller();
            byte[] messageMarshalled = null;

            while (true) {
                System.out.println("ON THREAD RUN");

                try {
                    this.queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("ON THREAD CONTINUE");

                if(this.queue.getSize() > this.queueSize) {

                    Message message = this.queue.dequeue();
                    ReplyPacket reply = new ReplyPacket();
                    reply.setBody(message);

                    try {
                        messageMarshalled = marshaller.marshall(reply);
                        handler.send(messageMarshalled);
                        this.queueSize++;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }

        }
    }
}
