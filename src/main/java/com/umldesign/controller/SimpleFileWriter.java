package com.umldesign.controller;
import com.umldesign.controller.FileBasedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * The SimpleFileWriter class is responsible for file write operation of the file.
 *
 * @author harishkumarsrinivasappa
 * @version 1.0
 */
public class SimpleFileWriter implements FileBasedWriter {
    /**
     * The write method is responsible for writing the data to the file passed.
     *
     * @param filePath the path of the file.
     * @param data the data to be written to the file.
     */
    @Override
    public void write(String filePath, String data) {
        File file = new File(filePath);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
