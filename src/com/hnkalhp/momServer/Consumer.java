package com.hnkalhp.momServer;

import java.io.IOException;

/**
 * Created by ceciliahunka on 18/11/17.
 */
public class Consumer {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        QueueManagerProxy queue01Proxy = new QueueManagerProxy("queue01");
        String response = queue01Proxy.receive();
        System.out.println(response);
    }

}
