package com.SimpleHTTPServer.interfaces;

import lombok.NonNull;

public interface FileService {
    String servFileContent(@NonNull String fileName);
}
