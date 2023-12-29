package com.umldesign.model;

/**
 * State class is used to maintain the state of the action performed by the user.
 *
 * @author Jashmin
 * @version 1.0
 */
public class State {
    private boolean isClicked = false;
    private int id = -1;
    private int x = -1;
    private int y = -1;
    private static State state;

    /**
     * The State constructor is private so that other classes cannot create object of it. It global across application
     * for maintain the user action state.
     */
    protected State(){}

    /**
     * This method returns the instance to the state object.
     *
     * @return instance of the state object.
     */
    public static State getInstance(){
        if(state == null)
            state = new State();
        return state;
    }

    /**
     * This method return previous click action status.
     *
     * @return boolean flag indicatin the previous click action.
     */
    public boolean isClicked() {
        return isClicked;
    }

    /**
     * This method sets the click action status.
     *
     * @param clicked boolean value to be set.
     */
    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    /**
     * return the id of the object for which the last click action was performed.
     *
     * @return id of the node.
     */
    public int getId() {
        return id;
    }

    /**
     * This method sets the id of the node for which the click action was performed.
     *
     * @param id node id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method return the xpos of the object.
     *
     * @return xpos value.
     */
    public int getX() {
        return x;
    }

    /**
     * This method sets the xpos of the object.
     *
     * @param x x position value.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * This method return the y positon of the object.
     *
     * @return y position value.
     */
    public int getY() {
        return y;
    }

    /**
     * This method sets the ypos of the object.
     *
     * @param y y position value.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * resets the state of this instance.
     */
    public void resetState(){
        this.id = -1;
        this.x = -1;
        this.y = -1;
        this.isClicked = false;
    }

    /**
     * sets the state with the following values.
     * @param id id of the node
     * @param x x pos of the node
     * @param y y pos of the node
     * @param isClicked click status of the node.
     */
    public void setState(int id, int x, int y, boolean isClicked){
        this.id = id;
        this.x = x;
        this.y = y;
        this.isClicked = isClicked;
    }
}

