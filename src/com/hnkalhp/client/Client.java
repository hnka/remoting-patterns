package com.hnkalhp.client;

import java.io.IOException;
import java.net.UnknownHostException;

import com.hnkalhp.ProtocolType;
import com.hnkalhp.client.protocols.ClientRequestTCP;
import com.hnkalhp.client.protocols.ClientRequestUDP;
import com.hnkalhp.server.Server;

public class Client {
	
	private ClientRequestHandler client;
	
	public Client(ProtocolType protocol, String host) {
		try {
			switch (protocol) {
			case TCP:
				this.client = new ClientRequestTCP(host, Server.PORT);
				break;
			case UDP:
				this.client = new ClientRequestUDP(host, Server.PORT);
				break;
			default:
				this.client = new ClientRequestTCP(host, Server.PORT);
				break;
			}
		} catch(UnknownHostException uException) {
			System.out.println("Host não existe");
			System.out.println(uException.getMessage());
			
		} catch(IOException ioException) {
			System.out.println("Problema na abertura da conexão");
			System.out.println(ioException.getMessage());
		}
	}
	
	// dar suporte a paralelismo
	public String requestToServer(String query) {
		
		return null;
	}
}
