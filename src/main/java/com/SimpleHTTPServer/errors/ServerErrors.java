package com.SimpleHTTPServer.errors;

import lombok.NonNull;

public final class ServerErrors extends RuntimeException {
    public static final String noBody = "No body";
    public static final String noAuth = "No auth";
    public ServerErrors(@NonNull String mess) {
        super(mess);
    }
}
