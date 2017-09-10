package com.hnkalhp;

import java.io.IOException;

import com.hnkalhp.client.Client;
import com.hnkalhp.server.Server;

public class Main {

    public static void main(String[] args) {
    	
    	ProtocolType protocol = ProtocolType.TCP;
    	if(args[0].toLowerCase().equals(ProtocolType.UDP.toString())) {
			protocol = ProtocolType.UDP;
		}
    	
    	if(args[1].toLowerCase().equals("client")) {
    		Client client = new Client(protocol, "localhost");
    		try {
    			System.out.println("indo");
				client.requestToServer("projeto");
				System.out.println("voltando");
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
			System.out.println("indo S");
    		Server server = new Server(protocol);
			System.out.println("voltando S");
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
