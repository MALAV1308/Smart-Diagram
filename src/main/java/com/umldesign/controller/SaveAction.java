package com.umldesign.controller;
import com.umldesign.controller.FileActionHandler;
import com.umldesign.model.Status;
import com.umldesign.view.StatusPanel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
/**
 * The SaveAction class is responsible for creating a copy of the repository and saving it to the file when the user
 * clicks on save button.
 *
 * @author harishkumarsrinivasappa
 * @author Naheer Fatima
 * @version 1.0
 */
public class SaveAction implements ActionListener {
    private FileActionHandler fileActionHandler;
    /**
     * The SaveAction constructor initializes the fileActionHandler.
     *
     * @param fileActionHandler reference to the file action handler instance.
     */
    public SaveAction(FileActionHandler fileActionHandler){
        this.fileActionHandler = fileActionHandler;
    }
    /**
     * The actionPerformed handles the user click action on save menu button and updates the status bar.
     *
     * @param e action event object.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Status.getInstance().setStatusMessage("Saving...");
        JFileChooser fileChooser = new JFileChooser();
        int res = fileChooser.showSaveDialog(null);
        if(res == JFileChooser.APPROVE_OPTION){
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            fileActionHandler.handle(file.getAbsolutePath());
            Status.getInstance().setStatusMessage("File Saved.");
        }
    }
}
