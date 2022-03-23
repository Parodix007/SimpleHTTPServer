package com.SimpleHTTPServer.impls;

import com.SimpleHTTPServer.interfaces.FileService;
import lombok.NonNull;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public class FileServiceImpl implements FileService {
    @Override
    public Optional<String> servFileContent(@NonNull String fileName) {
        InputStream resourceAsStream = getClass().getResourceAsStream(fileName);
        if (resourceAsStream == null) return Optional.empty();

        try {
            return Optional.of(new String(resourceAsStream.readAllBytes()));
        } catch (final IOException | JSONException e) {
            e.printStackTrace();
            System.out.printf("Error while reading file: %s", e.getMessage());
            return Optional.empty();
        }
    }
}
