package com.SimpleHTTPServer;

import com.SimpleHTTPServer.impls.ControllerImpl;
import com.SimpleHTTPServer.impls.FileServiceImpl;
import com.SimpleHTTPServer.impls.ServerImpl;
import com.SimpleHTTPServer.models.ServerHandler;

public class main {
    public static void main(String[] args) {
        ServerImpl server = new ServerImpl();
        ServerHandler serverHandler = new ServerHandler();
        serverHandler.setController(new ControllerImpl(new FileServiceImpl()));

        server.setServer(8080);
        server.setContext("/pp2", serverHandler);
        server.startServer();
    }
}
