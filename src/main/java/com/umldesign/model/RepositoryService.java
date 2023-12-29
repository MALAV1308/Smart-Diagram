package com.umldesign.model;
import com.umldesign.common.Relation;
/**
 * RepositoryService is a interface for interactions with the Repository.
 *
 * @author Aakash Vora
 * @version 1.0
 */
public interface RepositoryService {
    /**
     * 
     * Adds new box in the diagram
     * 
     * @param id Box id
     * @param name Name of the class
     * @param xpos X coordinate of class
     * @param ypos Y coordinate of class
     */
    public void addBox(int id, String name, int xpos, int ypos);
    /**
     * 
     * Adds new box in the diagram
     * 
     * @param name Name of the class
     * @param xpos X coordinate of class
     * @param ypos Y coordinate of class
     */
    public void addBox(String name, int xpos, int ypos);
    /**
     * 
     * Adds new connection in the diagram
     * 
     * @param connection Relation between the class
     * @param startId Class ID for the first class
     * @param endId Class ID for the second class
     */
    public void addConnection(Relation connection, int startId, int endId);
    /**
     * Resets the data, removes all classes and connection
     */
    public void resetData();
    /**
     * 
     * Updates existing box in the diagram
     * 
     * @param id Name of the class
     * @param xpos X coordinate of class
     * @param ypos Y coordinate of class
     */
    public void updateBoxPosition(int id, int xpos, int ypos);
}
