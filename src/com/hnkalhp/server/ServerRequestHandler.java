package com.hnkalhp.server;

public class ServerRequestHandler extends Thread {
	
	Object connection;
	ServerRequestProtocol serverProtocol;
	public ServerRequestHandler(ServerRequestProtocol serverProtocol, 
			Object connection) {
		this.connection = connection;
		this.serverProtocol = serverProtocol;
	}
	
	public void run() {
		try {
			byte[] data =  this.serverProtocol.getDataFromConnection(this.connection);
			
			// tratar data
			
			this.serverProtocol.send(this.connection, data);
		} catch (Exception e) {
			System.out.println("Erro no recebimento dos pacotes");
		}
	}
}
