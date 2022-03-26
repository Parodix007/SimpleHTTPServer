package com.SimpleHTTPServer.models;

import com.SimpleHTTPServer.errors.FileErrors;
import com.SimpleHTTPServer.interfaces.Controller;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import lombok.NonNull;


public abstract class HttpHandlerModel implements HttpHandler {
    protected Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    protected abstract void writeToResponse(@NonNull HttpExchange exchange, @NonNull String mess) throws FileErrors;
    protected abstract void sendResponse(@NonNull int status, @NonNull int bodyLength, @NonNull HttpExchange exchange);
}
