package com.hnkalhp.server.protocols;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.hnkalhp.server.ServerRequestProtocol;

public class ServerRequestTCP extends ServerRequestProtocol {
	
	protected ServerSocket tcpServerSocket = null;

	public ServerRequestTCP(int port) throws IOException {
		super(port);
		this.tcpServerSocket = new ServerSocket(port);
	}

	@Override
	public void send(Object connection, byte[] msg) throws IOException, InterruptedException {
		Socket socket = (Socket)connection;
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		output.flush();
		output.write(msg);
		output.close();
		socket.close();
	}

	@Override
	public Object receive() throws IOException, InterruptedException {
		return this.tcpServerSocket.accept();
	}
	
	public byte[] getDataFromConnection(Object connection) throws IOException {
		Socket socket = (Socket)connection;
		InputStream input = socket.getInputStream();
		String result = "";
		int value = input.read();
		while(value != -1) {
			byte caracter = (byte)value;
			result = result + ((char) caracter);
		}
		
		return result.getBytes();
	}

}
