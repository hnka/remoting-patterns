package com.hnkalhp.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerRequestHandler extends Thread {

    private Socket connectionSocket = null;

    private DataOutputStream outToClient = null;
    private DataInputStream inFromClient = null;

    public ServerRequestHandler(Socket connectionSocket) throws IOException {
        this.initializeSockets(connectionSocket);
    }
    
    public void initializeSockets(Socket connectionSocket) throws IOException {
    	this.connectionSocket = connectionSocket;
		this.outToClient = new DataOutputStream(this.connectionSocket.getOutputStream());
		this.inFromClient = new DataInputStream(this.connectionSocket.getInputStream());
	}

    public byte[] receive () throws IOException {
    	int msgSize = inFromClient.read();
		byte[] result = new byte[msgSize];
		int byteReads = this.inFromClient.read(result);
		
		if(byteReads == -1) {
			// error, dont read any byte 
		}
		
		return result;
    }

    public void send(byte[] message) throws IOException {
    	this.outToClient.writeInt(message.length);
    	this.outToClient.write(message);
    	this.outToClient.flush();
    }
    
    public void closeConecction() {
		try {
			this.connectionSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
