package com.umldesign.controller;
import com.umldesign.controller.FileActionHandler;
import com.umldesign.controller.FileBasedWriter;
import com.umldesign.controller.Serializer;
/**
 * The SaveActionHandler is responsible for serializing the repository and saving it in the file.
 *
 * @author harishkumarsrinivasappa
 * @version 1.0
 */
public class SaveActionHandler implements FileActionHandler {
    private Serializer serializer;
    private FileBasedWriter writer;
    /**
     * The SaveActionHandler is responsible for initializing the serializer and writer.
     *
     * @param serializer the serializer object reference.
     * @param writer the file writer reference.
     */
    public SaveActionHandler(Serializer serializer, FileBasedWriter writer){
        this.serializer = serializer;
        this.writer = writer;
    }
    /**
     * The handle method serializes the repository data and writes the serialized data to the file provided in the filepath.
     *
     * @param filePath path of the file on which we need to file operation.
     */
    public void handle(String filePath){
        String serializedData = serializer.serialize();
        writer.write(filePath,serializedData);
    }
}
