package org.example.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ConnectionHandler implements Runnable{
    private Socket client;

    public ConnectionHandler(Socket client){
        this.client = client;
    }
    @Override
    public void run(){
        try(InputStream inputStream = client.getInputStream();
            OutputStream outputStream = client.getOutputStream()){

            var request = getRequest(inputStream, outputStream);
            System.out.println("Request received: " + request);

        } catch (IOException e){
            System.out.println(e.toString());
        }
        finally {
            if (client != null){
                try{client.close();}
                catch (IOException e){
                    System.out.println(e);
                }
            }
        }
    }

    public HttpRequest getRequest(InputStream inputStream, OutputStream outputStream) throws IOException {
        int contentLength = inputStream.available();
        ByteBuffer buffer = ByteBuffer.allocate(contentLength);
        int bytesRead = inputStream.read(buffer.array(), 0, contentLength);
        buffer.flip();
        var str = new String(buffer.array(), 0, bytesRead, StandardCharsets.UTF_8);
        return HttpRequest.parse(str);
    }

}
