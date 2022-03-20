package com.SimpleHTTPServer.models;

import com.SimpleHTTPServer.interfaces.Controller;
import com.sun.net.httpserver.HttpHandler;


public abstract class HttpHandlerModel implements HttpHandler {
    protected Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
