package com.hnkalhp.momServer;

import java.io.IOException;

/**
 * Created by ceciliahunka on 18/11/17.
 */
public class Consumer {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

//        int messageNotReadIndex = 0;
        Subscriber subscriber = new Subscriber();

        QueueManagerProxy queue01Proxy = new QueueManagerProxy("queue01");
        queue01Proxy.addListener(subscriber);

//        while (messageNotReadIndex < 5) {
//            String response = queue01Proxy.receive(messageNotReadIndex);
//            System.out.println("Response is: " + response);
//            messageNotReadIndex++;
//        }

    }

}
