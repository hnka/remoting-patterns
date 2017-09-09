package com.hnkalhp.server.protocols;

import java.io.IOException;

import com.hnkalhp.server.ServerRequestHandler;

public class ServerRequestUDP extends ServerRequestHandler {

	public ServerRequestUDP(int port) throws IOException {
		super(port);
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
