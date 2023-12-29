package com.umldesign.controller;
/**
 * The FileBasedWriter interface enforces the file write behavior in the classes that implement it.
 *
 * @author harishkumarsrinivasappa
 * @version 1.0
 */
public interface FileBasedWriter {
    /**
     * The write method writes the data passed in the filepath.
     *
     * @param filePath the path of the file.
     * @param data the data to be written in the file.
     */
    public void write(String filePath, String data);
}
