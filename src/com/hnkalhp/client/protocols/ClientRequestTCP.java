package com.hnkalhp.client.protocols;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.hnkalhp.client.ClientRequestHandler;
import com.hnkalhp.server.protocols.ServerRequestTCP;

public class ClientRequestTCP extends ClientRequestHandler {

	private Socket clientSocket;
	private DataOutputStream outToServer;
	private DataInputStream inFromServer;

	public ClientRequestTCP(String host, int port) throws UnknownHostException, IOException {
		super(host, port);
	}

	@Override
	public void initializeSockets (String host, int port) throws IOException {
		this.clientSocket = new Socket(host, port);
	}

	@Override
	public void send(byte[] msg) throws IOException, InterruptedException {
		this.outToServer = new DataOutputStream(this.clientSocket.getOutputStream());
		this.outToServer.write(msg);
		this.outToServer.write(ServerRequestTCP.SEPARATOR_CARACTER);
		this.outToServer.flush();
		
	}

	@Override
	public byte[] receive() throws IOException, InterruptedException, ClassNotFoundException {
		this.inFromServer = new DataInputStream(this.clientSocket.getInputStream());
		String messageFromServer = "";
		
		int b = inFromServer.read();
		while(b != -1 && ((char) b) != ServerRequestTCP.SEPARATOR_CARACTER) {
			messageFromServer = messageFromServer + ((char) b);
			b = inFromServer.read();
		}
		return messageFromServer.getBytes();
	}

}
