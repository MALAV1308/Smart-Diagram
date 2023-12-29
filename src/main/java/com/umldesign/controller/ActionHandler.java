package com.umldesign.controller;
import com.umldesign.common.ActionType;
import java.awt.event.MouseEvent;

/**
 * ActionHandler interfaces is used to enforce the handle method behavior in the classes that implement it.
 *
 * @author harishkumarsrinivasappa
 * @version 1.0
 */
public interface ActionHandler {
    /**
     * The handle method performs appropriate actions on the basis of actiontype, id and event.
     *
     * @param actionType type of action performed like singleClick, DoubleClick etc.
     * @param id id of the node on which the action is performed.
     * @param e mouseevent generated.
     */
    public void handle(ActionType actionType, int id, MouseEvent e);
}
