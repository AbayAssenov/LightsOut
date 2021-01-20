package com.abay.assenov.lights_out.service;

import java.nio.file.Path;
import java.util.List;

public interface FileReaderService {

    List<Path> getAbsolutePathAllFileInFolder(Path pathToFolder);

    List<String> readLines(Path path);
}
