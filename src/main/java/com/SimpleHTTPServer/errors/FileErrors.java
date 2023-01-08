package com.SimpleHTTPServer.errors;

import lombok.NonNull;

import java.io.IOException;

public final class FileErrors extends IOException {

  public static final String fileReadingError = "Error while reading file";
  public static final String filetNotFound = "No file with that name";

  public FileErrors(@NonNull String mess) {
    super(mess);
  }
}
