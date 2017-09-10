package com.hnkalhp;

import java.io.IOException;

import com.hnkalhp.client.Client;
import com.hnkalhp.server.Server;

public class Main {

    public static void main(String[] args) {
    	
    	ProtocolType protocol = ProtocolType.TCP;
    	if(args[0].toUpperCase().equals(ProtocolType.UDP.toString())) {
			protocol = ProtocolType.UDP;
		}
    	
    	if(args[1].toLowerCase().equals("client")) {
    		
    		try {
    			for (int i = 0; i < 100; i++) {
    				Client client = new Client(protocol, "localhost");
    				String result = client.requestToServer("projeto " + i);
    				System.out.println("resultado: " + result);
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("não enviar a mensagem para o servidor");
			}
    	}
    	
    	if(args[1].toLowerCase().equals("server")) {
			System.out.println("inicializando Server");
    		Server server = new Server(protocol);
			System.out.println("inicializado");
    		try {
				server.startServerLoop();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("não foi possivel abrir o servidor");
			}
    	}

    }
}
