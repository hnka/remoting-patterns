package com.hnkalhp.momServer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ceciliahunka on 16/11/17.
 */
public class QueueManager {

    private String host;
    private int port;
    Map<String, Queue> queues = new HashMap<String, Queue>();

    public QueueManager() {};

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Map<String, Queue> getQueues() {
        return queues;
    }

    public Queue getQueue(String queueName) {
        Boolean queueExists = this.queues.containsKey(queueName);
        if (!queueExists) {
            this.queues.put(queueName, new Queue(queueName));
        }
        return this.queues.get(queueName);
    }
}
