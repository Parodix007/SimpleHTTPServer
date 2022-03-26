package com.SimpleHTTPServer.impls;

import com.SimpleHTTPServer.interfaces.Controller;
import com.SimpleHTTPServer.interfaces.FileService;
import lombok.NonNull;

import java.util.Optional;

public class ControllerImpl implements Controller {
    private final FileService fileService;

    public ControllerImpl(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public Optional<String> doGet(@NonNull String fileName) {
        Optional<String> s = fileService.servFileContent(fileName);
        if (s.isEmpty()) return Optional.empty();
        return s;
    }
}
