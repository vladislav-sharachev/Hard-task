package com.epam.vladislav_sharachev.java.lesson5.Demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("c:\\aVlad\\4.txt");
        System.out.println(path.getFileName() + " in" + path.getFileSystem());
        System.out.println(path.getRoot());
        for (Path element : path) {
            System.out.println(element);
        }
        Path pathDir = Paths.get("c:\\aVlad\\newdir2");
  /*      try {
            Path newDir = Files.createDirectory(pathDir);
        } catch (IOException e) {
            e.printStackTrace();
        } */
        System.out.println(Files.isReadable(path));
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isExecutable(path));

        Files.deleteIfExists(path);
    }
}