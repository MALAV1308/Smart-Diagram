package com.umldesign.model;
import java.util.Observable;
/**
 * Status class is reponsible for holding the current status of the application and notifying any UI elements observing
 * the status change.
 *
 * @author harishkumarsrinivasappa
 * @version 1.0
 */
public class Status extends Observable {
    private static Status status;
    private String currentStatus;
    /**
     * Status method private constructor restricts other classes from creating object of it.
     */
    private Status(){}
    /**
     * The getInstance method returns an instance of the status.
     *
     * @return status instance is returned.
     */
    public static Status getInstance(){
        if(status == null)
            status = new Status();
        return status;
    }
    /**
     * The getCurrentStatus return the current status
     *
     * @return currentStatus
     */
    public String getCurrentStatus(){
        return currentStatus;
    }

    /**
     * The setStatusMessage method sets the current Status and notifies the observers.
     *
     * @param statusMessage the status message.
     */
    public void setStatusMessage(String statusMessage){
        currentStatus = "Status Bar : "+statusMessage;

        setChanged();
        notifyObservers();
    }
}
