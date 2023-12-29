package com.umldesign.controller;
import com.umldesign.controller.FileBasedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * The SimpleFileReader class is responsible for file read operation of the file.
 *
 * @author harishkumarsrinivasappa
 * @version 1.0
 */
public class SimpleFileReader implements FileBasedReader {
    /**
     * The read method is responsible for read the data of the file passed.
     *
     * @param filePath the path of the file.
     * @return the file data or empty string on exception.
     */
    @Override
    public String read(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
