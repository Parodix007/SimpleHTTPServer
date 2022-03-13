package com.SimpleHTTPServer;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class main {
    public static void main(String[] args) throws IOException {
        System.out.println("HELLO WORLD");
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
        httpServer.createContext("/test", new HandlerTest());
        httpServer.start();
    }
}
