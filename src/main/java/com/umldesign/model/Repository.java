package com.umldesign.model;
import java.util.List;
import java.util.Observable;
import com.umldesign.common.Relation;
/**
 * The Repository class is responsible providing singleton instance of UML diagram.
 * UML diagram uses Graph class to store class & it's connection information.
 *
 * @author Deven Prajapati
 * @version 1.0
 */
public class Repository extends Observable {
    private static Repository instance;
    private Graph graph = new Graph();
    /**
     * The Repository constructor is a private restricting outside classes from creating objects of it.
     */
    private Repository() {}
    /**
     * The getInstance method is to get an instance of the Repository.
     *
     * @return instance of the Repository.
     */
    public static Repository getInstance() {
        if(instance == null)
            instance = new Repository();
        return instance;
    }
    /**
     * The reset method is to reset graph and notify all observers accordingly.
     */
    public void reset() {
        this.graph.reset();
        setChanged();
        notifyObservers();
    }
    /**
     * The getNodeById method is to get a Node by id.
     *
     * @param id to get Node from Graph based on id.
     * @return Node based on id.
     */
    public Node getNodeById(int id) {
        return graph.getNodeById(id);
    }
    /**
     * The addOrUpdateNodeById method is to add or update a Node by id in Graph.
     * It notifies all observers as well
     *
     * @param id to add or update node based on id in graph.
     * @param node to add or update node in graph by id
     */
    public void addOrUpdateNodeById(int id, Node node) {
        graph.addOrUpdateNodeById(id,node);
        setChanged();
        notifyObservers();
    }

    /**
     * The getEdgeById method is to get an Edges by id.
     *
     * @param id to get Edges from Graph based on id.
     * @return List<Edge> based on id.
     */
    public List<Edge> getEdgesById(int id) {
        return graph.getEdgesById(id);
    }

    /**
     * The setEdgeById method is to set an Edges by id.
     *
     * @param id to set Edges in Graph based on id.
     * @param edges to set Edges in Graph.
     */
    public void setEdgesById(int id, List<Edge> edges) {
        graph.setEdgesById(id, edges);
    }

    /**
     * The getEdgeById method is to get an Edges by id.
     *
     * @param node to get Edges from Graph based on node.
     * @return List<Edge> all edges related to node.
     */
    public List<Edge> getEdges(Node node) {
        return graph.getEdges(node);
    }

    /**
     * The setEdges method to set an Edges connected to node.
     *
     * @param node to set Edges in Graph based connected to node.
     * @param edges to add all edges related to node.
     */
    public void setEdges(Node node, List<Edge> edges) {
        graph.setEdges(node,edges);
    }

    /**
     * The addOrUpdateNode method is to add or update a Node in Graph.
     * It notifies all observers as well
     *
     * @param node to add or update node in graph
     */
    public void addOrUpdateNode(Node node) {
        graph.addOrUpdateNode(node);
        setChanged();
        notifyObservers();
    }

    /**
     * The addEdge method is to add edge in graph and set type and end nodes based on Node.
     * It notifies all observers as well
     *
     * @param type to set connection type between classes
     * @param startNode to set startNode of given edge
     * @param endNode to set endNode of given edge
     */
    public void addEdge(Relation type, Node startNode, Node endNode) {
        graph.addEdge(type,startNode,endNode);
        setChanged();
        notifyObservers();
    }

    /**
     * The addEdge method is to add edge in graph and set type and end nodes based on id.
     * It notifies all observers as well
     *
     * @param type to set connection type between classes
     * @param startNode to set startNode of given edge
     * @param endNode to set endNode of given edge
     */
    public void addEdge(Relation type, int startNode, int endNode) {
        graph.addEdge(type,startNode,endNode);
        setChanged();
        notifyObservers();
    }

    /**
     * The getNodes method is to get nodes in graph.
     *
     * @return List of nodes
     */
    public List<Node> getNodes() {
        return graph.getNodes();
    }

    /**
     * The getEdges method is to get edges in graph.
     *
     * @return List of edges
     */
    public List<Edge> getEdges() {
        return graph.getEdges();
    }

}
