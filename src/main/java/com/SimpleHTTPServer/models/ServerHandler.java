package com.SimpleHTTPServer.models;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ServerHandler extends HttpHandlerModel{
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        InputStream requestBody = exchange.getRequestBody();
        String s = new String(requestBody.readAllBytes(), StandardCharsets.UTF_8);
        System.out.println(s);
    }
}
