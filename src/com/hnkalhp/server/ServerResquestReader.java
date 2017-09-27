package com.hnkalhp.server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerResquestReader {
	private ServerSocket server;
	
	public ServerResquestReader(int port) throws IOException {
		this.server = new ServerSocket(port);
	}
	
	public ServerRequestHandler accept() throws IOException {
		return new ServerRequestHandler(this.server.accept());
	}
	
	public void close() {
		try {
			this.server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
