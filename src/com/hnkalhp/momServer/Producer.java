package com.hnkalhp.momServer;

import java.io.IOException;

/**
 * Created by ceciliahunka on 18/11/17.
 */
public class Producer {

    public static void main(String[] args) throws IOException, InterruptedException {

        int loop = 0;
        QueueManagerProxy queue01Proxy = new QueueManagerProxy("queue01");

        while (loop < 5) {
            queue01Proxy.send("sending message " + loop);
            loop++;
        }


    }
}
