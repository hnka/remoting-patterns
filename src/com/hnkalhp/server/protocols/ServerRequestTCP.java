package com.hnkalhp.server.protocols;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.hnkalhp.server.ServerRequestProtocol;

public class ServerRequestTCP extends ServerRequestProtocol {
	
	private ServerSocket welcomeSocket;

	public ServerRequestTCP(int port) throws IOException {
		super(port);
	}
	
	@Override
	public void initializeSockets (int port) throws IOException {
		this.welcomeSocket = new ServerSocket(port);
	}
	
	public String getDataFromConnection(Object connection) throws IOException, ClassNotFoundException {
		Socket socket = (Socket)connection;
		InputStream input = socket.getInputStream();
		
		String messageFromClient = "";
		int b = input.read();
		while(b != -1) {
			messageFromClient = messageFromClient + ((char) b);
			System.out.println(messageFromClient);
			b = input.read();
			System.out.println(b);
		}
		System.out.println(messageFromClient);
		System.out.println("out");
//		String messageFromClient = (String) inFromClient.readObject();
		
		return messageFromClient;
	}

	@Override
	public void send(Object connection, byte[] msg) throws IOException, InterruptedException {
		Socket connectionSocket = (Socket)connection;
		OutputStream output = connectionSocket.getOutputStream();
		ObjectOutputStream outToClient = new ObjectOutputStream(output);
		output.flush();
		outToClient.write(msg);
		output.close();
		connectionSocket.close();
	}

	@Override
	public Object receive() throws IOException, InterruptedException {
		return this.welcomeSocket.accept();
	}

}
