package com.hnkalhp.client.protocols;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.hnkalhp.client.ClientRequestHandler;

public class ClientRequestUDP extends ClientRequestHandler {

	private DatagramSocket clientSocket;
	private InetAddress IPAddress;
	private int port;

	public ClientRequestUDP(String host, int port) throws UnknownHostException, IOException {
		super(host, port);
	}

	@Override
	public void initializeSockets (String host, int port) throws IOException {
		this.clientSocket = new DatagramSocket();
		this.IPAddress = InetAddress.getByName(host);
		this.port = port;
	}

	@Override
	public void send(byte[] msg) throws IOException, InterruptedException {
		DatagramPacket outToServer = new DatagramPacket(msg, msg.length, this.IPAddress, this.port);
		this.clientSocket.send(outToServer);
	}

	@Override
	public byte[] receive() throws IOException, InterruptedException {
		byte[] receivedData = new byte[1024];
		DatagramPacket inFromServer = new DatagramPacket(receivedData, receivedData.length);
		this.clientSocket.receive(inFromServer);

		String messageFromServer = new String(inFromServer.getData());
		// needs to return byte[]?
		return null;
	}

}
