package com.hnkalhp.momServer;

import java.util.ArrayList;

/**
 * Created by ceciliahunka on 16/11/17.
 */
public class Queue {

    private String queueName;
    private ArrayList<Message> queue = new ArrayList<Message>();

    public Queue(String queueName) {
        this.queueName = queueName;
    }

    public void enqueue(Message msg) {
        this.queue.add(msg);
    }

    public Message dequeue(int index) {

        if (this.queue.size() == 0 || this.queueSize() < index + 1) {
            Message empty = new Message();
            empty.setHeader(new MessageHeader(this.queueName));
            empty.setBody(new MessageBody(""));

            return empty;
        } else {
            Message message = this.queue.get(index);
            return message;
        }
    }

    public int queueSize() {
        return this.queue.size();
    }
}
