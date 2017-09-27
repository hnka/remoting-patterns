package com.hnkalhp.client.proxies;

import com.hnkalhp.client.Invocation;
import com.hnkalhp.client.Termination;
import com.hnkalhp.client.requestor.Requestor;

import java.util.ArrayList;

/**
 * Created by ceciliahunka on 24/09/17.
 */
public class NamingProxy extends ClientProxy implements INamingService {

    public NamingProxy (String hostName, int portNumber) {
        super(hostName, portNumber);
    }
    public NamingProxy () { super(); }

    public void bind(String serviceName, ClientProxy clientProxy) throws Exception {
        Invocation invocation = new Invocation();
        Termination termination;

        ArrayList<Object> parameters = new ArrayList<>();
        class Local {}
        String methodName;
        Requestor requestor = new Requestor();

        methodName = Local.class.getEnclosingMethod().getName();
        parameters.add(serviceName);
        parameters.add(clientProxy);

        invocation.setObjectId(this.getObjectId());
        invocation.setHost(this.getHostName());
        invocation.setPortNumber(this.getPortNumber());
        invocation.setOperationName(methodName);
        invocation.setParameters(parameters);

        requestor.invoke(invocation);
    }

    public ClientProxy lookup(String name) throws Exception {
        Invocation invocation = new Invocation();
        Termination termination;

        ArrayList<Object> parameters = new ArrayList<>();
        class Local {}
        String methodName;
        Requestor requestor = new Requestor();

        methodName = Local.class.getEnclosingMethod().getName();
        parameters.add(name);

        invocation.setObjectId(this.getObjectId());
        invocation.setHost(this.getHostName());
        invocation.setPortNumber(this.getPortNumber());
        invocation.setOperationName(methodName);
        invocation.setParameters(parameters);

        requestor.invoke(invocation);
        termination = requestor.invoke(invocation);
        return (ClientProxy) termination.getResult();
    }

    public ArrayList<String> list() throws Exception {
        Invocation invocation = new Invocation();
        Termination termination;

        ArrayList<Object> parameters = new ArrayList<>();
        class Local {}
        String methodName;
        Requestor requestor = new Requestor();

        methodName = Local.class.getEnclosingMethod().getName();

        invocation.setObjectId(this.getObjectId());
        invocation.setHost(this.getHostName());
        invocation.setPortNumber(this.getPortNumber());
        invocation.setOperationName(methodName);
        invocation.setParameters(parameters);

        requestor.invoke(invocation);
        termination = requestor.invoke(invocation);
        return (ArrayList<String>) termination.getResult();
    }

}
