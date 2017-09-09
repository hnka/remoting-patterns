package com.hnkalhp.client.protocols;

import java.io.IOException;
import java.net.UnknownHostException;

import com.hnkalhp.client.ClientRequestHandler;

public class ClientRequestUDP extends ClientRequestHandler {

	public ClientRequestUDP(String host, int port) throws UnknownHostException, IOException {
		super(host, port);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void send(byte[] msg) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public byte[] receive() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

}
