package com.hnkalhp.momServer;

import com.hnkalhp.mom.performance.PerformanceTest;

import java.io.IOException;

/**
 * Created by ceciliahunka on 19/11/17.
 */
public class OtherConsumer {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        //        QueueManagerProxy queue01Proxy = new QueueManagerProxy("queue01");
//        Subscriber sub = new Subscriber();
//        queue01Proxy.receive(sub);

        PerformanceTest performanceTest = new PerformanceTest();
        Long[] results = performanceTest.performanceTest(1000, 100);

        System.out.println("RESULTS: --------------------------------------------");
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
        System.out.println("-----------------------------------------------------");

    }
}
