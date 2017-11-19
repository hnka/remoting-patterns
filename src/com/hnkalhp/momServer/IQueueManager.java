package com.hnkalhp.momServer;

import java.io.IOException;

/**
 * Created by ceciliahunka on 16/11/17.
 */
public interface IQueueManager {

    public void send(String msg) throws IOException, InterruptedException;
    public void receive() throws IOException, InterruptedException, ClassNotFoundException;

}
