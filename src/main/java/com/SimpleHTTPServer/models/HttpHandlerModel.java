package com.SimpleHTTPServer.models;

import com.SimpleHTTPServer.interfaces.Controller;

import java.util.LinkedList;
import java.util.List;

public abstract class HttpHandlerModel {
    protected List<Controller> controllers = new LinkedList<>();

    public void setControllers(List<Controller> controllers) {
        this.controllers = controllers;
    }
    public void setControllers(Controller controller) {
        this.controllers.add(controller);
    }
}
