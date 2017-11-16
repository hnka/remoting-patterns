package com.hnkalhp.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by ceciliahunka on 16/11/17.
 */
public class MOMClientRequestHandler {

    private String host;
    private int port;

    int sentMessageSize;
    int receiveMessageSize;

    private Socket clientSocket = null;
    private DataOutputStream outToServer = null;
    private DataInputStream inFromServer = null;

    public MOMClientRequestHandler(String host, int port) throws UnknownHostException, IOException {
        this.clientSocket = new Socket(host, port);
        this.outToServer = new DataOutputStream(this.clientSocket.getOutputStream());
        this.inFromServer = new DataInputStream(this.clientSocket.getInputStream());
    }

    public void send(byte[] msg) throws IOException, InterruptedException {

        this.sentMessageSize = msg.length;
        this.outToServer.writeInt(sentMessageSize);
        this.outToServer.write(msg, 0, sentMessageSize);
        this.outToServer.flush();

    }

    public byte[] receive() throws IOException, InterruptedException, ClassNotFoundException {

        this.receiveMessageSize = this.inFromServer.readInt();
        byte[] result = new byte[this.receiveMessageSize];
        int byteReads = this.inFromServer.read(result);

        if(byteReads == -1) {
            // error, dont read any byte
        }

        return result;
    }

    public void closeConection() {
        try {
            this.clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
