package com.umldesign.controller;
import com.umldesign.common.ActionType;
import com.umldesign.common.Relation;
import com.umldesign.model.RepositoryService;
import com.umldesign.model.State;
import com.umldesign.model.Status;
import com.umldesign.view.StatusPanel;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 * This class handles the single click action of the user.
 *
 * @author jashminpatel
 * @version 1.0
 */
public class DoubleClickHandler implements ActionHandler {

    private ActionHandler actionHandler;
    private RepositoryService service;

    /**
     * The constructor method here initializes the service instance.
     *
     * @param service reference to the service.
     */
    public DoubleClickHandler(RepositoryService service) {
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
     * getRelationship method gets the user input to select the relationship type.
     *
     */
    public String getRelationship() {

        Status.getInstance().setStatusMessage("Setting Connection between two classes...");
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton inheritanceButton = new JRadioButton();
        JRadioButton compositionButton = new JRadioButton();
        JRadioButton associationButton = new JRadioButton();

        inheritanceButton.setText("Inheritance");
        compositionButton.setText("Composition");
        associationButton.setText("Association");

        buttonGroup.add(inheritanceButton);
        buttonGroup.add(compositionButton);
        buttonGroup.add(associationButton);
        Object[] array = {"Select Relation", inheritanceButton, compositionButton, associationButton};
        int sel = javax.swing.JOptionPane.showConfirmDialog(null,array,"",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
        Status.getInstance().setStatusMessage("Added Connection.");
        if(sel == 0) {
        	if(inheritanceButton.isSelected())
        		return "INHERITENCE";
        	else if(compositionButton.isSelected())
        		return "COMPOSITION";
        	else
        		return "ASSOCIATION";
        }
        return "None";
    }

    /**
     * updateRelationship method add the connection as per the user input.
     *
     * @param actionType type of action performed like singleClick, DoubleClick etc.
     * @param id id of the node on which the action is performed.
     */
    public void updateRelationship(ActionType actionType, int id){
    	String relationType = getRelationship(); 
    	State state = State.getInstance();
    	
    	if(relationType.equals("None")) {
    		state.resetState();
        	return;
    	}

        if(relationType.equals("INHERITENCE"))
            service.addConnection(Relation.INHERITENCE,state.getId(),id);
        else if(relationType.equals("COMPOSITION"))
            service.addConnection(Relation.COMPOSITION,state.getId(),id);
        else
            service.addConnection(Relation.ASSOCIATION,state.getId(),id);
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
        if(actionType == ActionType.DOUBLE_CLICK){
            updateRelationship(actionType, id);
        }else{
            actionHandler.handle(actionType, id, e);
        }
    }
}
