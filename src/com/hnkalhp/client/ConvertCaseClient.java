package com.hnkalhp.client;

import com.hnkalhp.client.proxies.ConvertCaseProxy;
import com.hnkalhp.client.proxies.NamingProxy;

import java.io.IOException;
import java.net.UnknownHostException;

public class ConvertCaseClient {

    public static void main (String[] args) throws UnknownHostException, IOException, Exception {

        NamingProxy naming = new NamingProxy("localhost", 3000);
        ConvertCaseProxy convertCase = (ConvertCaseProxy) naming.lookup("ConvertCase");

        String testing = "eu estou tentando crescer";

        int i = 0;
        while (i < 10000) {
            //System.out.println(i);
            //System.out.println(testing);
            String result = convertCase.convertToUpperCase(testing);
            String resultLower = convertCase.convertToLowerCase(result);
            System.out.println(result);
            System.out.println(resultLower);
            i++;
        }

    }

}
