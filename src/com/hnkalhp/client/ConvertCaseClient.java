package com.hnkalhp.client;

import com.hnkalhp.client.proxies.ConvertCaseProxy;
import com.hnkalhp.client.proxies.NamingProxy;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by ceciliahunka on 24/09/17.
 */
public class ConvertCaseClient {

    public static void main (String[] args) throws UnknownHostException, IOException, Exception {

        NamingProxy naming = new NamingProxy("localhost", 3000);
        ConvertCaseProxy convertCase = (ConvertCaseProxy) naming.lookup("ConvertCase");

//        String testing = "eu estou tentando crescer";
//        System.out.println(testing);
//        String result = convertCase.convertToUpperCase(testing);
//        System.out.println(result);
//        int resultAdd = convertCase.add(10, 11);
//        System.out.println(resultAdd);
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
        	
        	long startTime = System.currentTimeMillis();
        	for (int j = 0; j < numberOfRequests; j++) {
        		convertCase.add(10, 11);
			}
        	long elapsedTime = System.currentTimeMillis() - startTime;
        	System.out.println(elapsedTime);
        	
        	Thread.sleep(timeInterTests);
		}
        
    }

}
