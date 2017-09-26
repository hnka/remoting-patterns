package com.hnkalhp.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientRequestHandler {

	private String host;
	private int port;
	private int sentMessageSize;
	private int receiveMessageSize;

	private Socket clientSocket = null;
	private DataOutputStream outToServer = null;
	private DataInputStream inFromServer = null;

	public ClientRequestHandler(String host, int port) throws UnknownHostException, IOException {
		this.initializeSockets(host, port);
	}

	public void initializeSockets(String host, int port) {
	}

	public void send(byte[] msg) throws IOException, InterruptedException {
	}

	public byte[] receive() throws IOException, InterruptedException, ClassNotFoundException {
		return null;
	}
}
