package com.SimpleHTTPServer.errors;

import lombok.NonNull;

import java.io.IOException;

public class FileErrors extends IOException {
    public static String fileReadingError = "Error while reading file";
    public static String filetNotFound = "No file with that name";
    public FileErrors(@NonNull String mess) {
        super(mess);
    }
}
