package com.umldesign.controller;
import com.umldesign.common.ActionType;
import com.umldesign.model.RepositoryService;
import com.umldesign.model.Status;
import com.umldesign.view.StatusPanel;
import java.awt.event.*;
import javax.swing.*;
/**
 * This class handles the single click action of the user.
 *
 * @author Naheer Fatima
 * @version 1.0
 */
public class SingleClickHandler implements ActionHandler {
    private RepositoryService service;
	private ActionHandler actionHandler;
	/**
	 * The constructor method here initializes the service instance.
	 *
	 * @param service reference to the service.
	 */
    public SingleClickHandler(RepositoryService service) {
        this.service = service;
    }
	/**
	 * set click handler method helps us to set the action handler variable so when the class receives different action
	 * it can pass on the action.
	 *
	 * @param actionHandler handler reference.
	 */
	public void setClickHandler(ActionHandler actionHandler){
		this.actionHandler = actionHandler;
	}
	/**
	 * The start method uses JOptionPane to get the name of the box and store the same in repository using repository
	 * service.
	 *
	 * @param e mouseEvent
	 */
	public void start(MouseEvent e) {
		Status.getInstance().setStatusMessage("Adding Class...");
		JOptionPane boxNameInputPane = new JOptionPane("Name:");
		boxNameInputPane.setWantsInput(true);
		JDialog boxNameInputDialog = boxNameInputPane.createDialog(null, "BoxName");
		boxNameInputDialog.setLocationRelativeTo((JComponent)e.getSource());
		boxNameInputDialog.setVisible(true);
		String boxName = (String) boxNameInputPane.getInputValue();
		service.addBox(boxName, e.getX(), e.getY());
		Status.getInstance().setStatusMessage("Class Added.");
	}

	/**
	 * The handle method checks and validates if its some action that this class handles or it passes it down the chain.
	 *
	 * @param actionType type of action performed like singleClick, DoubleClick etc.
	 * @param id id of the node on which the action is performed.
	 * @param e mouseevent generated.
	 */
	@Override
	public void handle(ActionType actionType, int id, MouseEvent e) {
		if(actionType == ActionType.SINGLE_CLICK){
			start(e);
		}else{
			actionHandler.handle(actionType, id, e);
		}
	}
}
