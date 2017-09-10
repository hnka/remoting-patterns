package com.hnkalhp.server;

import java.io.IOException;
import java.io.InputStream;

public abstract class ServerRequestProtocol {
	protected int portNumber;
	
	protected int sentMessageSize;
	protected int receivedMessageSize;
	
	public ServerRequestProtocol(int port) throws IOException {
		this.portNumber = port;
		this.initializeSockets(port);
	}
	public abstract void initializeSockets(int port) throws IOException;
	
	public abstract void send(Object connection, byte[] msg) throws IOException, InterruptedException;
	
	public abstract Object receive() throws IOException, InterruptedException;
	
	public abstract String getDataFromConnection(Object connection) throws IOException, ClassNotFoundException;
}
