package com.hnkalhp.server.protocols;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import com.hnkalhp.server.ServerRequestProtocol;

public class ServerRequestUDP extends ServerRequestProtocol {
	private DatagramSocket connectionSocket;
	
	public ServerRequestUDP(int port) throws IOException {
		super(port);
	}
	
	@Override
	public void initializeSockets (int port) throws SocketException {
		this.connectionSocket = new DatagramSocket(port);
	}

	@Override
	public void send(Object connection, byte[] msg) throws IOException, InterruptedException {
		DatagramPacket outToClient = (DatagramPacket) connection;
		this.connectionSocket.send(outToClient);
	}

	@Override
	public Object receive() throws IOException, InterruptedException {

		byte[] receivedData = new byte[1024];
        DatagramPacket inFromClient = new DatagramPacket(receivedData, receivedData.length);
        
		this.connectionSocket.receive(inFromClient);
		return inFromClient;
	}

	@Override
	public String getDataFromConnection(Object connection) throws IOException {
		DatagramPacket inFromClient = (DatagramPacket) connection;
		
		return new String(inFromClient.getData());
	}

}
