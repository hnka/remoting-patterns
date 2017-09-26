package com.hnkalhp.client;

import java.io.IOException;
import java.net.UnknownHostException;

public abstract class ClientRequestHandler {

	public ClientRequestHandler(String host, int port) throws UnknownHostException, IOException {
		this.initializeSockets(host, port);
	}

	public abstract void initializeSockets(String host, int port) throws IOException;

	public abstract void send(byte[] msg) throws IOException, InterruptedException;

	public abstract byte[] receive() throws IOException, InterruptedException, ClassNotFoundException;
}
