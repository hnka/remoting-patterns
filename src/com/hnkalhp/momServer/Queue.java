package com.hnkalhp.momServer;

import java.util.ArrayList;

/**
 * Created by ceciliahunka on 16/11/17.
 */
public class Queue {

    private String queueName;
    private ArrayList<Message> queue = new ArrayList<Message>();
    private ArrayList<Thread> listeners = new ArrayList<Thread>();

    public Queue(String queueName) {
        this.queueName = queueName;
    }

    public void enqueue(Message msg) {
        this.queue.add(msg);
        synchronized (this) {
            this.notifyAll();
        }
    }

    public Message dequeue() {

        if (this.queue.size() == 0) {
            Message empty = new Message();
            empty.setHeader(new MessageHeader(this.queueName));
            empty.setBody(new MessageBody(""));

            return empty;
        } else {
            Message message = this.queue.get(this.queue.size() - 1);
            return message;
        }
    }

    public int getSize() {
        return this.queue.size();
    }

    public void addListener(Thread t) {
        this.listeners.add(t);
    }

}
