package com.hnkalhp.client;

import com.hnkalhp.client.proxies.ConvertCaseProxy;
import com.hnkalhp.client.proxies.IConvertCase;
import com.hnkalhp.client.proxies.NamingProxy;

import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by ceciliahunka on 01/10/17.
 */
public class ConvertCaseRMIClient {

    public static void main (String[] args) throws UnknownHostException, IOException, Exception {

        Registry registry = LocateRegistry.getRegistry("localhost", 3000);
        IConvertCase convertCase = (IConvertCase) registry.lookup("ConvertCase");

//        System.out.println(convertCase.add(1, 3));
        
        int numberOfInvocations = 100;
        int numberOfRequests = 0;
        int numberOfRequestsGrow = 10;
        long timeInterTests = 1000;
        
        // primeiras chamadas são sempre mais lentas
        for (int i = 0; i < 100; i++) {
        	convertCase.add(10, 11);
		}
        
        for (int i = 0; i < numberOfInvocations; i++) {
        	
        	numberOfRequests += numberOfRequestsGrow;
        	
        	long startTime = System.nanoTime();
        	for (int j = 0; j < numberOfRequests; j++) {
        		convertCase.add(j, j);
			}
        	long elapsedTime = System.nanoTime() - startTime;
        	System.out.println(elapsedTime);
        	
        	Thread.sleep(timeInterTests);
		}

    }

}
