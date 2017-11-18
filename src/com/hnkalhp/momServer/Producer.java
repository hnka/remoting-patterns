package com.hnkalhp.momServer;

import java.io.IOException;

/**
 * Created by ceciliahunka on 18/11/17.
 */
public class Producer {

    public static void main(String[] args) throws IOException, InterruptedException {

        QueueManagerProxy queue01Proxy = new QueueManagerProxy("queue01");
        queue01Proxy.send("sending message");

    }
}
