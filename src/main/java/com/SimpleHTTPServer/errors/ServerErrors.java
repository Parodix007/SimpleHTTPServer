package com.SimpleHTTPServer.errors;

public class ServerErrors extends RuntimeException {
    public ServerErrors(String mess) {
        super(mess);
    }
}
