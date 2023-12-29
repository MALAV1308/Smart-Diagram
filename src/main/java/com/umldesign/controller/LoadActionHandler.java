package com.umldesign.controller;
import com.umldesign.controller.Deserializer;
import com.umldesign.controller.FileActionHandler;
import com.umldesign.controller.FileBasedReader;
/**
 * The LoadActionHandler is responsible for handling the file on load action.
 *
 * @author harishkumarsrinivasappa
 * @author Naheer Fatima
 * @version 1.0
 */
public class LoadActionHandler implements FileActionHandler {
    private FileBasedReader reader;
    private Deserializer deserializer;
    /**
     * The loadactionhandler constructor initializes filereader and deserializer.
     *
     * @param reader file reader object.
     * @param deserializer deserializer object.
     */
    public LoadActionHandler(FileBasedReader reader, Deserializer deserializer){
        this.reader = reader;
        this.deserializer = deserializer;
    }
    /**
     * The handle method is responsible for reading and deserializing the data from file.
     *
     * @param filePath path of the file on which we need to file operation.
     */
    public void handle(String filePath){
        String data = reader.read(filePath);
        deserializer.deserialize(data);
    }
}
