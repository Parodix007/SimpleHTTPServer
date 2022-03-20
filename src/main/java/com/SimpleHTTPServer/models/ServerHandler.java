package com.SimpleHTTPServer.models;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class ServerHandler extends HttpHandlerModel implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {}
}
