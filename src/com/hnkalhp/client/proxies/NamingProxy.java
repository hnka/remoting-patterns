package com.hnkalhp.client.proxies;

import java.util.ArrayList;

/**
 * Created by ceciliahunka on 24/09/17.
 */
public class NamingProxy extends ClientProxy implements INamingService {

    public NamingProxy (String hostName, int portNumber) {
        super(hostName, portNumber);
    }

    public void bind(String serviceName, ClientProxy clientProxy) throws Exception {};

    public ClientProxy lookup(String name) throws Exception {
        return null;
    }

    public ArrayList<String> list() throws Exception {
        return null;
    }

}
