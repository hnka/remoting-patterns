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
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initializeSockets (String host, int port) throws IOException {
		this.clientSocket = new Socket(host, port);
		this.outToServer = new ObjectOutputStream(this.clientSocket.getOutputStream());
		this.inFromServer = new ObjectInputStream(this.clientSocket.getInputStream());
	}

	@Override
	public void send(byte[] msg) throws IOException, InterruptedException {
		this.outToServer.write(msg);
	}

	@Override
	public byte[] receive() throws IOException, InterruptedException, ClassNotFoundException {
		String messageFromServer = (String) this.inFromServer.readObject();
		//byte[] ?
		return null;
	}

}
