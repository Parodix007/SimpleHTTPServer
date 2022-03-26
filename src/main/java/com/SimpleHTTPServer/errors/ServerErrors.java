package com.SimpleHTTPServer.errors;

import lombok.NonNull;

public class ServerErrors extends RuntimeException {
    public static String noBody = "No body";
    public static String noAuth = "No auth";
    public ServerErrors(@NonNull String mess) {
        super(mess);
    }
}
