package com.hnkalhp.server;

import java.io.IOException;

import com.hnkalhp.ProtocolType;
import com.hnkalhp.server.protocols.ServerRequestTCP;
import com.hnkalhp.server.protocols.ServerRequestUDP;

public class Server {
	
	public static final int PORT = 4200;
	private ServerRequestHandler server;
	
	public Server(ProtocolType protocol) {
		
		try {
			switch (protocol) {
			case TCP:
				this.server = new ServerRequestTCP(Server.PORT);
				break;
	
			case UDP:
				this.server = new ServerRequestUDP(Server.PORT);
				break;
				
			default:
				this.server = new ServerRequestTCP(Server.PORT);
				break;
			}
		} catch(IOException ioException) {
			System.out.println("Não foi possivel iniciar o servidor");
			System.out.println(ioException.getMessage());
		}
	}
	
	// suportar paralelismo
	public void startServerLoop() {
		
	}
	
}
