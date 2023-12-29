package com.umldesign.controller;
import com.umldesign.model.Repository;
import com.umldesign.model.RepositoryService;
import com.umldesign.model.Status;
import com.umldesign.view.StatusPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The NewAction class is responsible for resetting the repository when the user clicks on new button.
 *
 * @author harishkumarsrinivasappa
 * @author Naheer Fatima
 * @version 1.0
 */
public class NewAction implements ActionListener {
    private RepositoryService service;
    /**
     * The NewAction constructor initializes the repository service used for resetting the repository.
     *
     * @param service the repository service object.
     */
    public NewAction(RepositoryService service) {
        this.service = service;
    }
    /**
     * The actionPerformed handles the user click action on new menu button and updates the status bar.
     *
     * @param e action event object.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Repository.getInstance().reset();
        Status.getInstance().setStatusMessage("New Empty File Created");
    }
}
