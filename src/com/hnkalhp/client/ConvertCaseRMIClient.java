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

        System.out.println(convertCase.add(1, 3));

    }

}
