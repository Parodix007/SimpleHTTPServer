package com.SimpleHTTPServer.models;

import com.SimpleHTTPServer.errors.FileErrors;
import com.SimpleHTTPServer.errors.ServerErrors;
import com.SimpleHTTPServer.impls.AuthImpl;
import com.sun.net.httpserver.HttpExchange;
import lombok.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

public class ServerHandler extends HttpHandlerModel {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        InputStream requestBody = exchange.getRequestBody();
        String parsedBody = new String(requestBody.readAllBytes(), StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(parsedBody);
        List<String> authorization = exchange.getRequestHeaders().get("Authorization");
        if (!AuthImpl.getInstance().doAuth(authorization.get(0))) {
            sendResponse(401, ServerErrors.noAuth.length(), exchange);
            writeToResponse(exchange, ServerErrors.noAuth);
            exchange.close();
            return;
        }
        try {
            Optional<String> file = controller.doGet(jsonObject.getString("file"));
            file.ifPresentOrElse(content -> {
                sendResponse(200, content.length(), exchange);
                writeToResponse(exchange, content);
            }, () -> {
                sendResponse(500, FileErrors.filetNotFound.length(), exchange);
                writeToResponse(exchange, FileErrors.filetNotFound);
            });
        } catch (final JSONException e) {
            e.printStackTrace();
            sendResponse(400, ServerErrors.noBody.length(), exchange);
            writeToResponse(exchange, ServerErrors.noBody);
        }
        exchange.close();
    }

    @Override
    protected void writeToResponse(@NonNull HttpExchange exchange, @NonNull String mess) {
        try {
            exchange.getResponseBody().write(mess.getBytes(StandardCharsets.UTF_8));
        } catch (final IOException e) {
            e.printStackTrace();
            sendResponse(500, 0, exchange);
        }
    }

    @Override
    protected void sendResponse(@NonNull int status, @NonNull int bodyLength, @NonNull HttpExchange exchange) {
        try {
            exchange.sendResponseHeaders(status, bodyLength);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
