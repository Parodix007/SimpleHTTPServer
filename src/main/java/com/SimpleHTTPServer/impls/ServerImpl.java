package com.SimpleHTTPServer.impls;

import com.SimpleHTTPServer.errors.ServerErrors;
import com.SimpleHTTPServer.interfaces.Server;
import com.SimpleHTTPServer.models.HttpHandlerModel;
import com.sun.net.httpserver.HttpServer;
import lombok.NonNull;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.stream.Stream;

public class ServerImpl implements Server {
    private HttpServer httpServer;

    @Override
    public void setServer(@NonNull int port) throws ServerErrors {
        try {
            httpServer = HttpServer.create(new InetSocketAddress(port), 0);
        } catch (final IOException e) {
            throw new ServerErrors(String.format("error while creating server: %s", e.getMessage()));
        }
    }

    @Override
    public <Handler extends HttpHandlerModel> void setContext(@NonNull String[] paths, @NonNull Handler handler) throws ServerErrors {
        if (paths.length == 0) return;
        try {
            Stream<@NonNull String> stream = Arrays.stream(paths);
            stream.forEach(path -> {
                httpServer.createContext(path, handler);
            });
        } catch (final IllegalArgumentException e) {
            throw new ServerErrors(String.format("error while adding context: %s", e.getMessage()));
        }
    }

    @Override
    public <Handler extends HttpHandlerModel> void setContext(@NonNull String path, @NonNull Handler handler) throws ServerErrors {
        try {
            httpServer.createContext(path, handler);
        } catch (final IllegalArgumentException e) {
            throw new ServerErrors(String.format("error while adding context: %s", e.getMessage()));
        }
    }

    @Override
    public void startServer() {
        httpServer.start();
    }
}
