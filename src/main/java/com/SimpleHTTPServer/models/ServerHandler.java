package com.SimpleHTTPServer.models;

import com.sun.net.httpserver.HttpExchange;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class ServerHandler extends HttpHandlerModel {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        InputStream requestBody = exchange.getRequestBody();
        String parsedBody = new String(requestBody.readAllBytes(), StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(parsedBody);

        OutputStream responseBody = exchange.getResponseBody();
        try {
            Optional<String> file = controller.doGet(jsonObject.getString("file"));
            file.ifPresentOrElse(content -> {
                try {
                    responseBody.write(file.get().getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    System.out.println("Error");
                    e.printStackTrace();
                }
            }, () -> {
                String error = "Error";
                try {
                    exchange.sendResponseHeaders(500, error.length());
                    responseBody.write(error.getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    System.out.println("ERROR 2");
                    e.printStackTrace();
                }
            });
        } catch (final JSONException e) {
            e.printStackTrace();
            String responseMess = String.format("No body: %s", e.getMessage());
            responseBody.write(responseMess.getBytes(StandardCharsets.UTF_8));
            exchange.sendResponseHeaders(400, responseMess.length());
        }
        exchange.close();
    }
}
