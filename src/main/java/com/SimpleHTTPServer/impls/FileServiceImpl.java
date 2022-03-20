package com.SimpleHTTPServer.impls;

import com.SimpleHTTPServer.interfaces.FileService;
import lombok.NonNull;

public class FileServiceImpl implements FileService {
    @Override
    public String servFileContent(@NonNull String fileName) {
        return "";
    }
}
