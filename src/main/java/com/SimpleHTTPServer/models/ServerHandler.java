package com.SimpleHTTPServer.models;

import com.sun.net.httpserver.HttpExchange;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ServerHandler extends HttpHandlerModel {
    @Override
    public void handle(HttpExchange exchange) throws IOException, JSONException {
        InputStream requestBody = exchange.getRequestBody();
        String parsedBody = new String(requestBody.readAllBytes(), StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(parsedBody);
    }
}
