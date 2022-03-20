package com.SimpleHTTPServer.impls;

import com.SimpleHTTPServer.interfaces.Controller;
import com.SimpleHTTPServer.interfaces.FileService;
import lombok.NonNull;

public class ControllerImpl implements Controller {
    private final FileService fileService;

    public ControllerImpl(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public String doGet(@NonNull String fileName) {
        return fileService.servFileContent(fileName);
    }
}
