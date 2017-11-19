package com.hnkalhp.momServer;

/**
 * Created by ceciliahunka on 19/11/17.
 */
public class Subscriber {

    public Subscriber() {};

    public void receiveMessage(String message) {
        System.out.println("Response is: " + message);
    }
}
