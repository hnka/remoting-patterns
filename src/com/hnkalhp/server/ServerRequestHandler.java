package com.hnkalhp.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
//import java.net.DatagramSocket;
//import java.net.ServerSocket;
//import java.net.Socket;

public abstract class ServerRequestHandler {
	//private int portNumber;

	//private ServerSocket welcomeSocket = null;
	//private Socket connectionSocket = null; // mudar pra suportar paralelismo
	
	private int sentMessageSize;
	private int receivedMessageSize;
	private DataOutputStream outToClient = null;
	private DataInputStream inFromClient = null;
	
	public ServerRequestHandler(int port) throws IOException {
		//this.portNumber = port;
		//this.welcomeSocket = new ServerSocket(port);
		this.initializeSockets(port);
	}

	public abstract void initializeSockets(int port) throws IOException;
	
	public abstract void send(byte[] msg) throws IOException, InterruptedException;
	
	public abstract byte[] receive() throws IOException, InterruptedException, ClassNotFoundException;
}
