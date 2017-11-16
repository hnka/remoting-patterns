package com.hnkalhp.momServer;

import java.util.ArrayList;

/**
 * Created by ceciliahunka on 16/11/17.
 */
public class Queue {

    private ArrayList<Message> queue = new ArrayList<Message>();

    public Queue() {}

    public void enqueue(Message msg) {
        this.queue.add(msg);
    }

    public Message dequeue() {
        Message message = this.queue.get(0);
        this.queue.remove(0);

        return message;
    }

    public int queueSize() {
        return this.queue.size();
    }
}
