package com.SimpleHTTPServer;

import com.SimpleHTTPServer.impls.ServerImpl;
import com.SimpleHTTPServer.models.ServerHandler;

public class main {
    public static void main(String[] args) {
        ServerImpl server = new ServerImpl();
        ServerHandler serverHandler = new ServerHandler();

        server.setServer(8080);
        server.setContext("/test1", serverHandler);
        server.startServer();
    }
}
