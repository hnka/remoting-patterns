package com.hnkalhp.client.proxies;

import com.hnkalhp.client.Invocation;
import com.hnkalhp.client.Termination;
import com.hnkalhp.client.requestor.Requestor;

import java.util.ArrayList;

/**
 * Created by ceciliahunka on 24/09/17.
 */
public class ConvertCaseProxy extends ClientProxy implements IConvertCase {

    public ConvertCaseProxy (String hostName, int portNumber) {
        super(hostName, portNumber);
    }
    public ConvertCaseProxy () { super(); }

    public String convertToUpperCase(String text) throws Exception {
        Invocation invocation = new Invocation();
        Termination termination;

        ArrayList<Object> parameters = new ArrayList<>();
        class Local {}
        String methodName;
        Requestor requestor = new Requestor();

        methodName = Local.class.getEnclosingMethod().getName();
        parameters.add(text);

        invocation.setObjectId(this.getObjectId());
        invocation.setHost(this.getHostName());
        invocation.setPortNumber(this.getPortNumber());
        invocation.setOperationName(methodName);
        invocation.setParameters(parameters);

        termination = requestor.invoke(invocation);
        return (String) termination.getResult();
    }

    public String convertToLowerCase(String text) throws Exception {
        Invocation invocation = new Invocation();
        Termination termination;

        ArrayList<Object> parameters = new ArrayList<>();
        class Local {}
        String methodName;
        Requestor requestor = new Requestor();

        methodName = Local.class.getEnclosingMethod().getName();
        parameters.add(text);

        invocation.setObjectId(this.getObjectId());
        invocation.setHost(this.getHostName());
        invocation.setPortNumber(this.getPortNumber());
        invocation.setOperationName(methodName);
        invocation.setParameters(parameters);

        termination = requestor.invoke(invocation);
        return (String) termination.getResult();
    }

}
