package com.hnkalhp.momServer;

import java.io.Serializable;

/**
 * Created by ceciliahunka on 19/11/17.
 */
public class Subscriber implements ISubscriber, Serializable {

    public Subscriber() {};

    public void onEventReceived(String message) {
        System.out.println("Response is: " + message);
    }
}
