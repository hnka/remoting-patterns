package com.hnkalhp.server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRequestHandler extends Thread {

    private int port;
    private ServerSocket initialSocket = null;
    private Socket connectionSocket = null;

    private int sentMessageSize;
    private int receivedMessageSize;
    private DataOutputStream outToClient = null;
    private DataInputStream inFromClient = null;

    public ServerRequestHandler(int port) {
        this.port = port;
    }

    public byte[] receive () {
        return null;
    }

    public void send(byte[] message) {
    }

}
