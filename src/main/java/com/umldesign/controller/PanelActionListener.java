package com.umldesign.controller;
import com.umldesign.common.ActionType;
import com.umldesign.model.State;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * PanelActionListener extends the MouseAdapter to listen the mouse actions.
 *
 * @author jashminpatel
 * @version 1.0
 */
public class PanelActionListener extends MouseAdapter {
    private final ActionHandler actionHandler;
    private final ConcreteCollisionDetector detector;
    private State state = State.getInstance();
    private int selectedId = -1;

    /**
     * This constructor initialize the ActionHandler and ConcreteCollisionDetector instances
     *
     * @param actionHandler ActionHandler reference
     * @param detector ConcreteCollisionDetector reference
     */
    public PanelActionListener(ActionHandler actionHandler, ConcreteCollisionDetector detector){
        this.actionHandler = actionHandler;
        this.detector = detector;
    }

    /**
     * This method retrieve the position of mouse click and call the relevant handler
     *
     * @param evt MouseEvent reference
     */
    public void mouseClicked(MouseEvent evt){
        int xpos = evt.getX();
        int ypos = evt.getY();
        int id = detector.detectCollision(xpos,ypos);
        if(!state.isClicked()){
            if(id == -1)
                actionHandler.handle(ActionType.SINGLE_CLICK, id, evt);
            else
                state.setState(id, xpos, ypos, true);
        }
        else {
            if(id == -1) {
                state.resetState();
                actionHandler.handle(ActionType.SINGLE_CLICK, id, evt);
            }
            else{
                actionHandler.handle(ActionType.DOUBLE_CLICK, id, evt);
                state.resetState();
            }
        }
    }

    /**
     * This method retrieve the position of mouse press and detect the collision.
     *
     * @param evt MouseEvent reference
     */
    public void mousePressed(MouseEvent evt){
        this.selectedId = detector.detectCollision(evt.getX(),evt.getY());
    }

    /**
     * This method retrieve the position of mouse point while user drags the pointer and pass to the handler with DRAG actionType.
     *
     * @param evt MouseEvent reference
     */
    public void mouseDragged(MouseEvent evt){
    	state.resetState();
    	if(selectedId == -1) {
    		return;
    	}
    	actionHandler.handle(ActionType.DRAG, this.selectedId, evt);
    }

    /**
     * This method triggered when user releases mouse click, and it reset the selected classBox.
     *
     * @param evt MouseEvent reference
     */
    public void mouseReleased(MouseEvent evt) {
    	this.selectedId = -1;

    }
}
