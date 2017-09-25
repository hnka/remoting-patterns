package com.hnkalhp.client.proxies;

import java.util.ArrayList;

/**
 * Created by ceciliahunka on 24/09/17.
 */
public interface INamingService {

    void bind(String serviceName, ClientProxy clientProxy) throws Exception;
    ClientProxy lookup(String name) throws Exception;
    ArrayList<String> list() throws Exception;

}