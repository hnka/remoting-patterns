package com.hnkalhp.client.marshaller;

import com.hnkalhp.client.requestor.message.Message;

import java.io.*;

/**
 * Created by ceciliahunka on 24/09/17.
 */
public class Marshaller {

    public byte[] marshall(Message message) throws IOException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectStream = new ObjectOutputStream(outputStream);
        objectStream.writeObject(message);

        return outputStream.toByteArray();
    }

    public Message unmarshall(byte[] message) throws IOException, ClassNotFoundException {

        ByteArrayInputStream inputStream = new ByteArrayInputStream(message);
        ObjectInputStream objectStream = new ObjectInputStream(inputStream);

        return (Message) objectStream.readObject();
    }

}
