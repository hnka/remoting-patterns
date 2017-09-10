package com.hnkalhp.client.protocols;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.hnkalhp.client.ClientRequestHandler;

public class ClientRequestTCP extends ClientRequestHandler {

	private Socket clientSocket;
	private ObjectOutputStream outToServer;
	private ObjectInputStream inFromServer;

	public ClientRequestTCP(String host, int port) throws UnknownHostException, IOException {
		super(host, port);
	}

	@Override
	public void initializeSockets (String host, int port) throws IOException {
		this.clientSocket = new Socket(host, port);
	}

	@Override
	public void send(byte[] msg) throws IOException, InterruptedException {
		this.outToServer = new ObjectOutputStream(this.clientSocket.getOutputStream());
		this.outToServer.write(msg);
	}

	@Override
	public byte[] receive() throws IOException, InterruptedException, ClassNotFoundException {
		this.inFromServer = new ObjectInputStream(this.clientSocket.getInputStream());
		String messageFromServer = (String) this.inFromServer.readObject();
		return messageFromServer.getBytes();
	}

}
