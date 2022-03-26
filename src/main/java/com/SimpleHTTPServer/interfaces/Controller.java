package com.SimpleHTTPServer.interfaces;

import lombok.NonNull;

import java.util.Optional;

public interface Controller {
    Optional<String> doGet(@NonNull String fileName);
}
