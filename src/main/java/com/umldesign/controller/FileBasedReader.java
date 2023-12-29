package com.umldesign.controller;
/**
 * The FileBasedReader interface enforces the file read behavior in the classes that implement it.
 *
 * @author harishkumarsrinivasappa
 * @version 1.0
 */
public interface FileBasedReader {
    /**
     * The read method read the data from the filepath passed.
     *
     * @param filePath the path of the file.
     * @return the data of the file.
     */
    public String read(String filePath);
}
