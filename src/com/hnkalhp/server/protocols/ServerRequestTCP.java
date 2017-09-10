package com.hnkalhp.server.protocols;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import com.hnkalhp.server.ServerRequestHandler;

public class ServerRequestTCP extends ServerRequestHandler {

	private ServerSocket welcomeSocket;
	private Socket connectionSocket;

	public ServerRequestTCP(int port) throws IOException {
		super(port);
	}

	@Override
	public void initializeSockets (int port) throws IOException {
		this.welcomeSocket = new ServerSocket(port);
		this.connectionSocket = this.welcomeSocket.accept();
	}

	@Override
	public void send(byte[] msg) throws IOException, InterruptedException {
		OutputStream output = this.connectionSocket.getOutputStream();
		ObjectOutputStream outToClient = new ObjectOutputStream(output);
		outToClient.write(msg);
	}

	@Override
	public byte[] receive() throws IOException, InterruptedException, ClassNotFoundException {
		InputStream input = this.connectionSocket.getInputStream();
		ObjectInputStream inFromClient = new ObjectInputStream(input);

		String messageFromClient = (String) inFromClient.readObject();
		// needs to return byte[]?
		return null;
	}

}
