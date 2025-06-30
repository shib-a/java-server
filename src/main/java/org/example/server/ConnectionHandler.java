package org.example.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

public class ConnectionHandler implements Runnable{
    private Socket client;

    public ConnectionHandler(Socket client){
        this.client = client;
    }
    @Override
    public void run(){
        try(InputStream inputStream = client.getInputStream();
            OutputStream outputStream = client.getOutputStream()){

        } catch (IOException e){
            System.out.println(e.toString());
        }
    }

    public String getRequest(InputStream inputStream, OutputStream outputStream) throws IOException {
        int contentLength = inputStream.available();
        ByteBuffer buffer = ByteBuffer.allocate(contentLength);
        inputStream.read(buffer.array(), 0, contentLength);
    }

}
