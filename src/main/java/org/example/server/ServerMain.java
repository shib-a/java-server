package org.example.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    private static boolean doRunServer = true;
    private boolean doAcceptRequests = true;
    private final int port = 9000;
    private final InetSocketAddress socketAddress = new InetSocketAddress(port);
    private static final int connectionLimit = 100;
    private ServerSocket serverSocket;
    public void runServer() throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.bind(socketAddress);
        while(doRunServer){
            Socket clientSocket = serverSocket.accept();
            new Thread(new ConnectionHandler(clientSocket)).start();
        }
    }

    public static void setDoRunServer(boolean runServer) {
        doRunServer = runServer;
    }
}
