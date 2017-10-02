package com.hnkalhp.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.hnkalhp.client.proxies.IConvertCase;

/**
 * Created by ceciliahunka on 26/09/17.
 */
public class ConvertCaseRemoteObject extends UnicastRemoteObject implements IConvertCase {

    public ConvertCaseRemoteObject() throws RemoteException {
        super();
    }

    public String convertToUpperCase (String text) {
        return text.toUpperCase();
    }

    public String convertToLowerCase (String text) {
        return text.toLowerCase();
    }
    
    public int add(int a, int b) {
    	return a + b;
    }

}
