package com.hnkalhp.server.protocols;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import com.hnkalhp.server.ServerRequestHandler;

public class ServerRequestUDP extends ServerRequestHandler {

	private DatagramSocket connectionSocket;
	private InetAddress IPAddress;
	private int port;

	public ServerRequestUDP(int port) throws IOException {
		super(port);
	}

	@Override
	public void initializeSockets (int port) throws SocketException {
		this.connectionSocket = new DatagramSocket(port);
	}

	@Override
	public void send(byte[] msg) throws IOException, InterruptedException {
		DatagramPacket outToClient = new DatagramPacket(msg, msg.length, this.IPAddress,this.port);
		this.connectionSocket.send(outToClient);
		this.IPAddress = null;
		this.port = 0;
	}

	@Override
	public byte[] receive() throws IOException, InterruptedException {
		byte[] receivedData = new byte[1024];
		DatagramPacket inFromClient = new DatagramPacket(receivedData, receivedData.length);

		this.IPAddress = inFromClient.getAddress();
		this.port = inFromClient.getPort();

		String messageFromClient = new String(inFromClient.getData());
		// needs to return byte[]?
		return null;
	}

}
