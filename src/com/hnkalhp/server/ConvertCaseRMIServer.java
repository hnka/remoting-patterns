package com.hnkalhp.server;

import com.hnkalhp.client.proxies.ConvertCaseProxy;
import com.hnkalhp.client.proxies.NamingProxy;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by ceciliahunka on 01/10/17.
 */
public class ConvertCaseRMIServer {

    public static void main (String[] args) throws Exception {

        ConvertCaseRemoteObject convertCase = new ConvertCaseRemoteObject();
        Registry registry = LocateRegistry.getRegistry("localhost", 3000);

        registry.bind("ConvertCase", convertCase);

    }

}
