package com.hnkalhp.server;

import java.io.IOException;

public abstract class ServerRequestProtocol {
	protected int portNumber;
	
	protected int sentMessageSize;
	protected int receivedMessageSize;
	
	public ServerRequestProtocol(int port) throws IOException {
		this.portNumber = port;
	}
	
	public abstract void send(Object connection, byte[] msg) throws IOException, InterruptedException;
	
	public abstract Object receive() throws IOException, InterruptedException;
	
	public abstract byte[] getDataFromConnection(Object connection) throws IOException;
}
