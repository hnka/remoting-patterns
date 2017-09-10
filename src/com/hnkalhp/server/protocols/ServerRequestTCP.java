package com.hnkalhp.server.protocols;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.hnkalhp.server.ServerRequestProtocol;

public class ServerRequestTCP extends ServerRequestProtocol {
	
	public static final char SEPARATOR_CARACTER = ';';
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
		while(b != -1 && ((char) b) != SEPARATOR_CARACTER) {
			messageFromClient = messageFromClient + ((char) b);
			b = input.read();
		}
		
		return messageFromClient;
	}

	@Override
	public void send(Object connection, byte[] msg) throws IOException, InterruptedException {
		Socket connectionSocket = (Socket)connection;
		OutputStream output = connectionSocket.getOutputStream();
		DataOutputStream outToClient = new DataOutputStream(output);
		output.flush();
		outToClient.write(msg);
		outToClient.write(SEPARATOR_CARACTER);
		output.close();
		connectionSocket.close();
	}

	@Override
	public Object receive() throws IOException, InterruptedException {
		return this.welcomeSocket.accept();
	}

}
