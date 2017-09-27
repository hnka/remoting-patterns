package com.hnkalhp.namingServer;

import com.hnkalhp.client.Termination;
import com.hnkalhp.client.marshaller.Marshaller;
import com.hnkalhp.client.proxies.ClientProxy;
import com.hnkalhp.client.requestor.message.Message;
import com.hnkalhp.client.requestor.message.MessageBody;
import com.hnkalhp.client.requestor.message.MessageHeader;
import com.hnkalhp.client.requestor.reply.ReplyBody;
import com.hnkalhp.client.requestor.reply.ReplyHeader;
import com.hnkalhp.server.ServerRequestHandler;
import com.hnkalhp.server.ServerResquestReader;

/**
 * Created by ceciliahunka on 26/09/17.
 */
public class NamingInvoker {

    public NamingInvoker () {}

    public void invoke(ClientProxy clientProxy, NamingRepository repository) throws Exception {
    	ServerResquestReader requestReader = new ServerResquestReader(clientProxy.getPortNumber());
        ServerRequestHandler requestHandler;

        byte[] messageToBeUnmarshalled = null;
        byte[] messageMarshalled = null;
        Message messageUnmarshalled = new Message();

        Marshaller marshaller = new Marshaller();
        Termination termination = new Termination();

        NamingRemoteObject remoteObject = new NamingRemoteObject(repository);

        while (true) {
        	
        	requestHandler = requestReader.accept();
            messageToBeUnmarshalled = requestHandler.receive();
            messageUnmarshalled = marshaller.unmarshall(messageToBeUnmarshalled);

            switch (messageUnmarshalled.getBody().getRequestHeader().getOperation()) {
                case "bind":
                    System.out.println("ON BIND");
                    String firstParam = (String) messageUnmarshalled.getBody().getRequestBody().getParameters().get(0);
                    ClientProxy secondParam = (ClientProxy) messageUnmarshalled.getBody().getRequestBody().getParameters().get(1);
                    remoteObject.bind(firstParam, secondParam);
                    break;
                case "lookup":
                    String param = (String) messageUnmarshalled.getBody().getRequestBody().getParameters().get(0);
                    termination.setResult(remoteObject.lookup(param));

                    //verificar parametros
                    MessageHeader header = new MessageHeader("protocolo", 0, false, 0, 0);

                    ReplyHeader replyHeader = new ReplyHeader("", 0, 0);
                    ReplyBody replyBody = new ReplyBody(termination.getResult());

                    MessageBody body = new MessageBody(null, null, replyHeader, replyBody);
                    Message messageToBeMarshalled = new Message(header, body);

                    messageMarshalled = marshaller.marshall(messageToBeMarshalled);
                    requestHandler.send(messageMarshalled);

                    break;
                case "list":
                    termination.setResult(remoteObject.list());

                    //verificar parametros
                    MessageHeader listHeader = new MessageHeader("protocolo", 0, false, 0, 0);

                    ReplyHeader listReplyHeader = new ReplyHeader("", 0, 0);
                    ReplyBody listReplyBody = new ReplyBody(termination.getResult());

                    MessageBody listBody = new MessageBody(null, null, listReplyHeader, listReplyBody);
                    Message listMessageToBeMarshalled = new Message(listHeader, listBody);

                    messageMarshalled = marshaller.marshall(listMessageToBeMarshalled);
                    requestHandler.send(messageMarshalled);

                    break;
                default:
                    System.out.println("Not a suitable method for NAMING, Try again.");
                    break;
            }

        }

    }

}
