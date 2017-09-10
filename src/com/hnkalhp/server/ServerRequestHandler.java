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

			byte[] dataResponse = messageFromClient.toUpperCase().getBytes();
			
			this.serverProtocol.send(this.connection, dataResponse);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro no recebimento dos pacotes");
		}
	}
}
