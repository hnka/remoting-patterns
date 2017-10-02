package com.hnkalhp.namingServer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by ceciliahunka on 01/10/17.
 */
public class NamingRMIServer {

    public static void main(String[] args) throws RemoteException, InterruptedException {
        LocateRegistry.createRegistry(3000);

        while(true){
            Thread.sleep(1000);
        }
    }

}
