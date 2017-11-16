package com.hnkalhp.momServer;

import com.hnkalhp.client.requestor.message.*;

import java.io.*;

/**
 * Created by ceciliahunka on 16/11/17.
 */
public class Marshaller {

    public byte[] marshall(Object obj) throws IOException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectStream = new ObjectOutputStream(outputStream);
        objectStream.writeObject(obj);

        return outputStream.toByteArray();
    }

    public Object unmarshall(byte[] obj) throws IOException, ClassNotFoundException {

        ByteArrayInputStream inputStream = new ByteArrayInputStream(obj);
        ObjectInputStream objectStream = new ObjectInputStream(inputStream);

        return (Object) objectStream.readObject();
    }
}
