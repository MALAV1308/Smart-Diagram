package com.umldesign.model;
import com.umldesign.common.Relation;
/**
 * The Edge class is responsible for storing connection between Nodes.
 *
 * @author Deven Prajapati
 * @version 1.0
 */
public class Edge {
    private Relation type = Relation.ASSOCIATION;
    private int startNode, endNode;
    /**
     * The Edge constructor initializes the Edge.
     */
    public Edge(Relation type, int startNode, int endNode) {
        this.type = type;
        this.startNode = startNode;
        this.endNode = endNode;
    }
    /**
     * The getType method is to get a type of connection.
     *
     * @return relation type between class.
     */
    public Relation getType() {
        return type;
    }

    /**
     * The setType method is to set relation type.
     *
     * @param type relation type between classes.
     */
    public void setType(Relation type) {
        this.type = type;
    }
    /**
     * The getStartNode method is to get startNode of connection.
     *
     * @return id of start node of connection.
     */
    public int getStartNode() {
        return startNode;
    }
    /**
     * The setStartNode method is to set startNode of connection.
     *
     * @param startNode of relation between classes.
     */
    public void setStartNode(int startNode) {
        this.startNode = startNode;
    }
    /**
     * The getEndNode method is to get endNode of connection.
     *
     * @return id of end node of connection.
     */
    public int getEndNode() {
        return endNode;
    }
    /**
     * The setEndNode method is to set endNode of connection.
     *
     * @param endNode of relation between classes.
     */
    public void setEndNode(int endNode) {
        this.endNode = endNode;
    }
}
