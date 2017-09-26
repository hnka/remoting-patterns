package com.hnkalhp.server;

import com.hnkalhp.client.proxies.ConvertCaseProxy;
import com.hnkalhp.client.proxies.NamingProxy;

/**
 * Created by ceciliahunka on 26/09/17.
 */
public class ConvertCaseServer {

    public static void main (String[] args) throws Exception {

        ConvertCaseInvoker invoker = new ConvertCaseInvoker();
        ConvertCaseProxy convertCase = new ConvertCaseProxy();

        NamingProxy naming = new NamingProxy("localhost", 3000);
        naming.bind("ConvertCase", convertCase);

        invoker.invoke(convertCase);

    }

}
