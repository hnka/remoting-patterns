package com.hnkalhp.momServer;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by ceciliahunka on 18/11/17.
 */
public class ServerRequestReader {

    private ServerSocket server;

    public ServerRequestReader(int port) throws IOException {
        this.server = new ServerSocket(port);
    }

    public ServerRequestHandler accept() throws IOException {
        return new ServerRequestHandler(this.server.accept());
    }

    public void close() {
        try {
            this.server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
