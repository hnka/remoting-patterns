package com.hnkalhp.namingServer;

import com.hnkalhp.client.proxies.NamingProxy;

/**
 * Created by ceciliahunka on 26/09/17.
 */
public class NamingServer {

    public static void main (String[] args) throws Exception {

        NamingInvoker invoker = new NamingInvoker();
        NamingProxy naming = new NamingProxy();
        NamingRepository repository = new NamingRepository();

        invoker.invoke(naming, repository);

    }

}
