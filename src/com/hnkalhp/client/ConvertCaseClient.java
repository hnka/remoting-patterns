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

        NamingProxy naming = new NamingProxy("localhost", 4000);
        ConvertCaseProxy convertCase = (ConvertCaseProxy) naming.lookup("ConvertCase");
        convertCase.convertToUpperCase("eu estou tentando crescer");

    }

}
