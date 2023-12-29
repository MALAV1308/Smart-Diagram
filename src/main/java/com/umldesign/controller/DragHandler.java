package com.umldesign.controller;
import com.umldesign.common.ActionType;
import com.umldesign.model.RepositoryService;
import com.umldesign.model.Status;
import com.umldesign.view.StatusPanel;
import java.awt.event.MouseEvent;

/**
 * This class handles the Drag mouse pointer action.
 *
 * @author jashminpatel
 * @version 1.0
 */
public class DragHandler implements ActionHandler {
    private RepositoryService service;

    /**
     * The constructor method here initializes the service instance.
     *
     * @param service reference to the service.
     */
    public DragHandler(RepositoryService service) {
        this.service = service;
    }

    /**
     * The handle method checks and validates if its some action that this class is responsible.
     *
     * @param actionType type of action performed
     * @param id id of the node on which the action is performed.
     * @param e mouseevent generated.
     */
    @Override
    public void handle(ActionType actionType, int id, MouseEvent e) {
    	if(actionType == ActionType.DRAG){
            updatePosition(id, e);
        }
    }

    /**
     * This method update the box position and status.
     *
     * @param id id of the node on which the action is performed.
     * @param e mouseevent generated.
     */
    private void updatePosition(int id, MouseEvent e) {
        service.updateBoxPosition(id, e.getX(), e.getY());
        Status.getInstance().setStatusMessage("Dragging Class.");
    }
}

