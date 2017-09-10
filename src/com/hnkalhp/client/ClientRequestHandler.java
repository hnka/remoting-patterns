package com.hnkalhp.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public abstract class ClientRequestHandler {
	private String host;
	private int port;
	private int sentMesageSize;
	private int receiveMessageSize;
	
	private Socket clientSocket;
	private DataOutputStream outToServer;
	private DataInputStream inFromServer;
	
	public ClientRequestHandler(String host, int port) throws UnknownHostException, IOException {
//		this.host = host;
//		this.port = port;
//		this.clientSocket = new Socket(host, port);
//		this.outToServer = null;
//		this.inFromServer = null;
		this.initializeSockets(host, port);
	}

	public abstract void initializeSockets(String host, int port) throws IOException;
	
	public abstract void send(byte[] msg) throws IOException, InterruptedException;
	
	public abstract byte[] receive() throws IOException, InterruptedException, ClassNotFoundException;
}
