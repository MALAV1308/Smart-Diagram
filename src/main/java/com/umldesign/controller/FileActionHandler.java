package com.umldesign.controller;
/**
 * The FileActionHandler interface enforces the handle behavior in classes the implement it.
 *
 * @author harishkumarsrinivasappa
 * @version 1.0
 */
public interface FileActionHandler {
    /**
     * The method handle takes the filePath and peforms file related operation on it.
     *
     * @param filePath path of the file on which we need to file operation.
     */
    public void handle(String filePath);
}
