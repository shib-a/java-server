package org.example.server;

public class ScriptScanner {
    public void scanScripts() {
        String classpath = System.getProperty("java.class.path");
        System.out.println("Scanning classpath: " + classpath);
    }
}
