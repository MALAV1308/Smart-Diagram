package com.umldesign.model;
import com.umldesign.common.Relation;
/**
 * Implementation of RepositoryService interface.
 *
 * @author Aakash Vora
 * @version 1.0
 */
public class ConcreteRepositoryService implements RepositoryService {
    /**
     * addBox adds a box to the repository.
     *
     * @param id Box id
     * @param name Name of the class
     * @param xpos X coordinate of class
     * @param ypos Y coordinate of class
     */
    @Override
    public void addBox(int id, String name, int xpos, int ypos) {
        Node node = Repository.getInstance().getNodeById(id);
        if(node == null) {
            node = new Node(id, name, xpos, ypos);
        } else {
            node.setName(name);
            node.setX(xpos);
            node.setY(ypos);
        }
        Repository.getInstance().addOrUpdateNodeById(id, node);
        
    }

    /**
     * addBox which adds box and creates id for the box created using uniqueIdGenerator
     *
     * @param name Name of the class
     * @param xpos X coordinate of class
     * @param ypos Y coordinate of class
     */
    @Override
    public void addBox(String name, int xpos, int ypos) {
        int id = UniqueIdGenerator.getInstance().getId();
        Repository.getInstance().addOrUpdateNode(new Node(id, name, xpos, ypos));
    }

    /**
     * This methods adds a connection to the repository.
     *
     * @param connection Relation between the class
     * @param startId Class ID for the first class
     * @param endId Class ID for the second class
     */
    @Override
    public void addConnection(Relation connection, int startId, int endId) {
        Repository.getInstance().addEdge(connection, startId, endId);     
    }

    /**
     * This method resets the repository.
     */
    @Override
    public void resetData() {
        Repository.getInstance().reset();
        
    }

    /**
     * This method updates the box position
     *
     * @param id Name of the class
     * @param xpos X coordinate of class
     * @param ypos Y coordinate of class
     */
    @Override
    public void updateBoxPosition(int id, int xpos, int ypos) {
        Node node = Repository.getInstance().getNodeById(id);
        if (node != null) { 
            node.setX(xpos);
            node.setY(ypos);
            Repository.getInstance().addOrUpdateNodeById(id, node);
        }

    }
    
}
