package com.SimpleHTTPServer.interfaces;

import lombok.NonNull;

import java.util.Optional;

public interface FileService {
    Optional<String> servFileContent(@NonNull String fileName);
}
