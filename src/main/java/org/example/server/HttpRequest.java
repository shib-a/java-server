package org.example.server;

import java.util.HashMap;

public class HttpRequest {
    private HashMap<String, String> rawHeaders;
    private String method;
    private String uri;
    public static HttpRequest parse(String request) {
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.rawHeaders = new HashMap<>();

        String[] lines = request.split("\r\n");
        if (lines.length > 0) {
            String[] firstLineParts = lines[0].strip().split(" ");
            httpRequest.method = firstLineParts[0];
            httpRequest.uri = firstLineParts[1];
        }
        for (String line : lines) {
            if (line.isEmpty()) {
                continue; // Skip empty lines
            }
            String[] parts = line.split(": ", 2);
            if (parts.length == 2) {
                httpRequest.rawHeaders.put(parts[0], parts[1]);
            } else {
                // Handle the request line or malformed header
                System.out.println("Malformed header: " + line);
            }
        }

        return httpRequest;
    }
}
