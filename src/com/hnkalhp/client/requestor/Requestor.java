package com.hnkalhp.client.requestor;

import com.hnkalhp.client.ClientRequestHandler;
import com.hnkalhp.client.Invocation;
import com.hnkalhp.client.Termination;
import com.hnkalhp.client.marshaller.Marshaller;
import com.hnkalhp.client.requestor.message.Message;
import com.hnkalhp.client.requestor.message.MessageBody;
import com.hnkalhp.client.requestor.message.MessageHeader;
import com.hnkalhp.client.requestor.request.RequestBody;
import com.hnkalhp.client.requestor.request.RequestHeader;

import java.io.IOException;

/**
 * Created by ceciliahunka on 24/09/17.
 */
public class Requestor {

    public Termination invoke(Invocation inv) throws IOException, InterruptedException, ClassNotFoundException {

        ClientRequestHandler requestHandler = new ClientRequestHandler(inv.getHost(), inv.getPortNumber());
        Marshaller marshaller = new Marshaller();
        Termination termination = new Termination();

        byte[] messageMarshalled;
        byte[] messageToBeUnmarshalled;

        Message messageUnmarshalled;

        // conferir os parametros do request header / body e message header / body
        RequestHeader requestHeader = new RequestHeader("", 0, true, inv.getObjectId(), inv.getOperationName());
        RequestBody requestBody = new RequestBody(inv.getParameters());

        MessageHeader messageHeader = new MessageHeader("MIOP", 0, false, 0, 0);
        MessageBody messageBody = new MessageBody(requestHeader, requestBody, null, null);
        Message messageToBeMarshalled = new Message(messageHeader, messageBody);

        messageMarshalled = marshaller.marshall(messageToBeMarshalled);
        requestHandler.send(messageMarshalled);

        messageToBeUnmarshalled = requestHandler.receive();
        messageUnmarshalled = marshaller.unmarshall(messageToBeUnmarshalled);

        System.out.println("REQUESTOR RETURN");
        System.out.println(messageUnmarshalled.getBody().getReplyBody().getOperationResult());

        termination.setResult(messageUnmarshalled.getBody().getReplyBody().getOperationResult());

        return termination;
    }

}
