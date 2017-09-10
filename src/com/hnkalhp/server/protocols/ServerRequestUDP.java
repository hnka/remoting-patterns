package com.hnkalhp.server.protocols;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import com.hnkalhp.server.ServerRequestProtocol;

public class ServerRequestUDP extends ServerRequestProtocol {
	DatagramSocket udpSocket;
	public ServerRequestUDP(int port) throws IOException {
		super(port);
		this.udpSocket = new DatagramSocket(port);
	}

	@Override
	public void send(Object connection, byte[] msg) throws IOException, InterruptedException {
		DatagramPacket packet = (DatagramPacket) connection;
		packet.setData(msg);
		this.udpSocket.send(packet);
	}

	@Override
	public Object receive() throws IOException, InterruptedException {

        byte[] msg = new byte[256];
        DatagramPacket packet = new DatagramPacket(msg, msg.length);
        
		this.udpSocket.receive(packet);
		return packet;
	}

	@Override
	public byte[] getDataFromConnection(Object connection) throws IOException {
		DatagramPacket packet = (DatagramPacket) connection;
		
		return packet.getData();
	}

}
