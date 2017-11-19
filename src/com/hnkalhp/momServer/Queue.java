package com.hnkalhp.momServer;

import java.util.ArrayList;

/**
 * Created by ceciliahunka on 16/11/17.
 */
public class Queue {

    private String queueName;
    private ArrayList<Message> queue = new ArrayList<Message>();
    private ArrayList<ISubscriber> listeners = new ArrayList<ISubscriber>();

    public Queue(String queueName) {
        this.queueName = queueName;
    }

    public void enqueue(Message msg) {

        this.queue.add(msg);
        this.sendMessageToListeners(msg);
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

    public void addListener(ISubscriber listener) {
        this.listeners.add(listener);
    }

    public void sendMessageToListeners(Message message) {
        int index = 0;
        while (index < this.listeners.size()) {
            ISubscriber sub = this.listeners.get(index);
            String finalMessage = message.getBody().getBody();
            sub.onEventReceived(finalMessage);
            index++;
        }
    }
}
