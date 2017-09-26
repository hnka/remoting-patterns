package com.hnkalhp.server;


import java.io.IOException;

public class ServerRequestHandler extends Thread {

//	Object connection;
//	ServerRequestProtocol serverProtocol;
//	public ServerRequestHandler(ServerRequestProtocol serverProtocol,
//			Object connection) {
//		this.connection = connection;
//		this.serverProtocol = serverProtocol;
//	}
//
//	public void run() {
//		try {
//			String messageFromClient =  this.serverProtocol.getDataFromConnection(this.connection);
//
//			byte[] dataResponse = messageFromClient.toUpperCase().getBytes();
//
//			this.serverProtocol.send(this.connection, dataResponse);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Erro no recebimento dos pacotes");
//		}
//	}

//	protected int portNumber;
//
//	protected int sentMessageSize;
//	protected int receivedMessageSize;
//
//	public ServerRequestProtocol(int port) throws IOException {
//		this.portNumber = port;
//		this.initializeSockets(port);
//	}
//	public abstract void initializeSockets(int port) throws IOException;
//
//	public abstract void send(Object connection, byte[] msg) throws IOException, InterruptedException;
//
//	public abstract Object receive() throws IOException, InterruptedException;
//
//	public abstract String getDataFromConnection(Object connection) throws IOException, ClassNotFoundException;
}
