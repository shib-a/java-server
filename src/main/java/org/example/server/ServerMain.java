package org.example.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    private static boolean doRunServer = true;
    private boolean doAcceptRequests = true;
    private static final int port = 6969;
    private static final InetSocketAddress socketAddress = new InetSocketAddress(port);
    private static final int connectionLimit = 100;
    private static ServerSocket serverSocket;
    private static ServerConfig _serverConfig;
    public static void runServer() throws IOException {
        serverSocket = new ServerSocket(port);
//        serverSocket.bind(socketAddress);
        while(doRunServer){
            Socket clientSocket = serverSocket.accept();
            System.out.println("New request");
            new Thread(new ConnectionHandler(clientSocket)).start();
        }
    }

    public static void setDoRunServer(boolean runServer) {
        doRunServer = runServer;
    }

    public static void start(ServerConfig serverConfig) {
        _serverConfig = serverConfig;

    }
}
