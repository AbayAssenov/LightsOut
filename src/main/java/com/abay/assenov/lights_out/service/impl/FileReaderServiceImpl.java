package com.abay.assenov.lights_out.service.impl;

import com.abay.assenov.lights_out.service.FileReaderService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public List<Path> getAbsolutePathAllFileInFolder(Path pathToFolder) {
        List<Path> pathToFileList = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(pathToFolder)) {
            paths.filter(Files::isRegularFile).forEach(pathToFileList::add);
        } catch (IOException e) {
            System.err.println("Wrong path or incorrect access : ");
            e.printStackTrace();
        }
        return pathToFileList;
    }

    @Override
    public List<String> readLines(Path path) {
        List<String> lines = new ArrayList<>();
        //try-with-resources
        try (Stream<String> linesStream = Files.lines( path ))
        {
            linesStream.forEach(lines::add);
        }
        catch (IOException e)
        {
            System.err.println("Not found file or incorrect access : ");
            e.printStackTrace();
        }
        return lines;
    }
}
