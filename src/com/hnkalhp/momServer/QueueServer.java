package com.hnkalhp.momServer;

import java.io.IOException;

/**
 * Created by ceciliahunka on 16/11/17.
 */
public class QueueServer {

    public static void main (String[] args) throws Exception {

        QueueInvoker invoker = new QueueInvoker();
        QueueManager manager = new QueueManager();
        invoker.invoke(manager, 3000);

    }

}
