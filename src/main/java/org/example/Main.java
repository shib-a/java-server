package org.example;

import org.example.server.ScriptScanner;
import org.example.server.ServerConfig;
import org.example.server.ServerMain;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            ServerConfig config = new ServerConfig.ServerConfigBuilder()
                    .setWorkingDirectory("/home/shibeyshi/IdeaProjects/java-server/src/main/java")
                    .build();
            new ScriptScanner().scanScripts();
            ServerMain.runServer();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}