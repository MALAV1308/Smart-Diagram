package com.umldesign.controller;
import com.umldesign.controller.FileActionHandler;
import com.umldesign.model.Status;
import com.umldesign.view.StatusPanel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
/**
 * The LoadAction class is responsible for providing the user with file chooser for the choosing the file he would like
 * to load.
 *
 * @author harishkumarsrinivasappa
 * @author Naheer Fatima
 * @version 1.0
 */
public class LoadAction implements ActionListener {
    private FileActionHandler fileActionHandler;
    /**
     * The LoadAction constructor takes the fileactionhandler which is then used for performing file operations on the file
     * choosed by the user.
     *
     * @param fileActionHandler the file action handler.
     */
    public LoadAction(FileActionHandler fileActionHandler){
        this.fileActionHandler = fileActionHandler;
    }
    /**
     * The actionPerformed method provides the user with file picker on the load action and handles the file using file
     * aciton handler.
     *
     * @param e actionEvent object.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Status.getInstance().setStatusMessage("Loading File...");
        JFileChooser fileChooser = new JFileChooser();
        int res = fileChooser.showOpenDialog(null);
        if(res == JFileChooser.APPROVE_OPTION){
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            fileActionHandler.handle(file.getAbsolutePath());
            Status.getInstance().setStatusMessage("File Loaded.");
        }
    }
}
