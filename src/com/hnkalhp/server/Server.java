package com.hnkalhp.server;

import java.io.IOException;

import com.hnkalhp.ProtocolType;
import com.hnkalhp.server.protocols.ServerRequestTCP;
import com.hnkalhp.server.protocols.ServerRequestUDP;

public class Server {
	
	public static final int PORT = 4200;
	private ServerRequestProtocol serverProtocol;
	
	public Server(ProtocolType protocol) {
		
		try {
			switch (protocol) {
			case TCP:
				this.serverProtocol = new ServerRequestTCP(Server.PORT);
				break;
	
			case UDP:
				this.serverProtocol = new ServerRequestUDP(Server.PORT);
				break;
				
			default:
				this.serverProtocol = new ServerRequestTCP(Server.PORT);
				break;
			}
		} catch(IOException ioException) {
			System.out.println("Não foi possivel iniciar o servidor");
			System.out.println(ioException.getMessage());
		}
	}
	
	public void startServerLoop() throws IOException, InterruptedException {
		while(true) {
			Object connection = this.serverProtocol.receive();
			ServerRequestHandler requestThread = new ServerRequestHandler(serverProtocol, connection);
			requestThread.start();
		}
	}
	
}
