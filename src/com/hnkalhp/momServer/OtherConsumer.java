package com.hnkalhp.momServer;

import java.io.IOException;

/**
 * Created by ceciliahunka on 19/11/17.
 */
public class OtherConsumer {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        QueueManagerProxy queue01Proxy = new QueueManagerProxy("queue01");
        Subscriber sub = new Subscriber();
        queue01Proxy.receive(sub);

    }
}
