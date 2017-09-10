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
			String messageFromClient =  this.serverProtocol.getDataFromConnection(this.connection);
			
			// ver oq vai retornar pro client
			
			byte[] dataResponse = new byte[0];
			
			this.serverProtocol.send(this.connection, dataResponse);
		} catch (Exception e) {
			System.out.println("Erro no recebimento dos pacotes");
		}
	}
}
