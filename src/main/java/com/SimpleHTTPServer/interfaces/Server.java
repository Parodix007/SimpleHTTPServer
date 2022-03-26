package com.SimpleHTTPServer.interfaces;

import com.SimpleHTTPServer.errors.ServerErrors;
import com.SimpleHTTPServer.models.HttpHandlerModel;
import lombok.NonNull;

public interface Server {
    void setServer(@NonNull int port) throws ServerErrors;
    <Handler extends HttpHandlerModel> void setContext(@NonNull String[] paths, @NonNull Handler handler) throws ServerErrors;
    <Handler extends HttpHandlerModel> void setContext(@NonNull String path, @NonNull Handler handler) throws ServerErrors;
    void startServer();
}
