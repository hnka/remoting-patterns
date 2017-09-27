package com.hnkalhp.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientRequestHandler {

	private Socket clientSocket = null;
	private DataOutputStream outToServer = null;
	private DataInputStream inFromServer = null;

	public ClientRequestHandler(String host, int port) throws UnknownHostException, IOException {
		this.initializeSockets(host, port);
	}

	public void initializeSockets(String host, int port) throws UnknownHostException, IOException {
		this.clientSocket = new Socket(host, port);
		this.outToServer = new DataOutputStream(this.clientSocket.getOutputStream());
		this.inFromServer = new DataInputStream(this.clientSocket.getInputStream());
	}

	public void send(byte[] msg) throws IOException, InterruptedException {
		this.outToServer.writeInt(msg.length);
		this.outToServer.write(msg);
		this.outToServer.flush();
	}

	public byte[] receive() throws IOException, InterruptedException, ClassNotFoundException {

		System.out.println(this.clientSocket.isConnected());
		int msgSize = inFromServer.read();
		System.out.println(msgSize);
		byte[] result = new byte[msgSize];
		int byteReads = this.inFromServer.read(result);
		
		if(byteReads == -1) {
			// error, dont read any byte 
		}
		
		return result;
	}
	
	public void closeConecction() {
		try {
			this.clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
