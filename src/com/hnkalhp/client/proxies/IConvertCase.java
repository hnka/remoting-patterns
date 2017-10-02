package com.hnkalhp.client.proxies;

import java.rmi.Remote;

/**
 * Created by ceciliahunka on 24/09/17.
 */
public interface IConvertCase extends Remote {

    String convertToUpperCase(String text) throws Exception;
    String convertToLowerCase(String text) throws Exception;
    int add(int firstNumber, int secondNumber) throws Exception;

}
