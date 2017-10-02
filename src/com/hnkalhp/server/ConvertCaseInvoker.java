package com.hnkalhp.server;

import com.hnkalhp.client.Termination;
import com.hnkalhp.client.marshaller.Marshaller;
import com.hnkalhp.client.proxies.ClientProxy;
import com.hnkalhp.client.requestor.message.Message;
import com.hnkalhp.client.requestor.message.MessageBody;
import com.hnkalhp.client.requestor.message.MessageHeader;
import com.hnkalhp.client.requestor.reply.ReplyBody;
import com.hnkalhp.client.requestor.reply.ReplyHeader;

import java.io.IOException;

/**
 * Created by ceciliahunka on 26/09/17.
 */
public class ConvertCaseInvoker {

    public ConvertCaseInvoker() {}

    public void invoke(ClientProxy clientProxy) throws IOException, ClassNotFoundException {
        ServerResquestReader requestReader = new ServerResquestReader(clientProxy.getPortNumber());
        ServerRequestHandler requestHandler;

        byte[] messageToBeUnmarshalled = null;
        byte[] messageMarshalled = null;
        Message messageUnmarshalled = new Message();

        Marshaller marshaller = new Marshaller();
        Termination termination = new Termination();

        ConvertCaseRemoteObject remoteObject = new ConvertCaseRemoteObject();

        while (true) {
        	requestHandler = requestReader.accept();
            messageToBeUnmarshalled = requestHandler.receive();
            messageUnmarshalled = marshaller.unmarshall(messageToBeUnmarshalled);

            switch (messageUnmarshalled.getBody().getRequestHeader().getOperation()) {
                case "convertToUpperCase":
                    String param = (String) messageUnmarshalled.getBody().getRequestBody().getParameters().get(0);
                    termination.setResult(remoteObject.convertToUpperCase(param));

                    //verificar parametros
                    MessageHeader header = new MessageHeader("protocolo", 0, false, 0, 0);

                    ReplyHeader replyHeader = new ReplyHeader("", 0, 0);
                    ReplyBody replyBody = new ReplyBody(termination.getResult());

                    MessageBody body = new MessageBody(null, null, replyHeader, replyBody);
                    Message messageToBeMarshalled = new Message(header, body);

                    messageMarshalled = marshaller.marshall(messageToBeMarshalled);
                    requestHandler.send(messageMarshalled);
                    break;
                case "convertToLowerCase":
                    String lowerParam = (String) messageUnmarshalled.getBody().getRequestBody().getParameters().get(0);
                    termination.setResult(remoteObject.convertToLowerCase(lowerParam));

                    //verificar parametros
                    MessageHeader lowerHeader = new MessageHeader("protocolo", 0, false, 0, 0);

                    ReplyHeader lowerReplyHeader = new ReplyHeader("", 0, 0);
                    ReplyBody lowerReplyBody = new ReplyBody(termination.getResult());

                    MessageBody lowerBody = new MessageBody(null, null, lowerReplyHeader, lowerReplyBody);
                    Message lowerMessageToBeMarshalled = new Message(lowerHeader, lowerBody);

                    messageMarshalled = marshaller.marshall(lowerMessageToBeMarshalled);
                    requestHandler.send(messageMarshalled);
                    break;
                case "add":
                	int addParam1 = (int) messageUnmarshalled.getBody().getRequestBody().getParameters().get(0);
                	int addParam2 = (int) messageUnmarshalled.getBody().getRequestBody().getParameters().get(1);
                    termination.setResult(remoteObject.add(addParam1, addParam2));

                    //verificar parametros
                    MessageHeader addHeader = new MessageHeader("protocolo", 0, false, 0, 0);

                    ReplyHeader addReplyHeader = new ReplyHeader("", 0, 0);
                    ReplyBody addReplyBody = new ReplyBody(termination.getResult());

                    MessageBody addBody = new MessageBody(null, null, addReplyHeader, addReplyBody);
                    Message addMessageToBeMarshalled = new Message(addHeader, addBody);

                    messageMarshalled = marshaller.marshall(addMessageToBeMarshalled);
                    requestHandler.send(messageMarshalled);
                    break;
                default:
                    System.out.println("Not a suitable method for CONVERT CASE, Try again.");
                    break;
            }

        }


    }

}
