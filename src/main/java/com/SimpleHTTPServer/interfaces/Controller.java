package com.SimpleHTTPServer.interfaces;

import lombok.NonNull;

public interface Controller {
    String doGet(@NonNull String fileName);
}
