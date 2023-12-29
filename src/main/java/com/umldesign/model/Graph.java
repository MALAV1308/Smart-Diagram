package com.umldesign.model;
import java.util.*;
import com.umldesign.common.Relation;
/**
 * The Graph class is responsible for storing Class, connection between class.
 * It uses Node and Edge class and keep them in list accordingly.
 *
 * @author Deven Prajapati
 * @version 1.0
 */
public class Graph {
    private Map<Integer,Node> idToNodeMap;
    private Map<Integer,List<Edge>> idToEdgeMap;
    /**
     * The Graph constructor initializes the Graph.
     */
    public Graph() {
        this.idToNodeMap = new HashMap<>();
        this.idToEdgeMap = new HashMap<>();
    }
    /**
     * The reset method is to reset graph and notify all observers accordingly.
     */
    public void reset(){
        this.idToNodeMap.clear();
        this.idToEdgeMap.clear();
    }
    /**
     * The Graph constructor initializes the Graph.
     */
    public Graph(List<Node> nodes, List<Edge> edges) {
        for (Node node : nodes) {
            idToNodeMap.put(node.getId(), node);
            idToEdgeMap.put(node.getId(), new ArrayList<Edge>());
        }
        for (Edge edge : edges) {
            List<Edge> edgeList = idToEdgeMap.get(edge.getStartNode());
            edgeList.add(edge);
        }
    }
    /**
     * The getNodeById method is to get a Node by id.
     *
     * @param id to get Node from list based on id.
     * @return Node based on id.
     */
    public Node getNodeById(int id) {
        return idToNodeMap.get(id);
    }

    /**
     * The addOrUpdateNodeById method is to add or update a Node by id in list.
     *
     * @param id to add or update node based on id in list.
     * @param node to add or update node in graph by id
     */
    public void addOrUpdateNodeById(int id, Node node) {
        if(!idToNodeMap.containsKey(id)){
            this.idToEdgeMap.put(id, new ArrayList<Edge>());
        }
        this.idToNodeMap.put(id, node);
    }

    /**
     * The getEdgeById method is to get an Edges by id from list.
     *
     * @param id to get Edges from list based on id.
     * @return List<Edge> based on id.
     */
    public List<Edge> getEdgesById(int id) {
        return idToEdgeMap.get(id);
    }

    /**
     * The setEdgeById method is to set an Edges by id.
     *
     * @param id to set Edges in list based on id.
     * @param edges to set Edges in list.
     */
    public void setEdgesById(int id, List<Edge> edges) {
        this.idToEdgeMap.put(id, edges);
    }

    /**
     * The getEdges method is to get an Edges by Node.
     *
     * @param node to get Edges from list based on node.
     * @return List<Edge> all edges related to node.
     */
    public List<Edge> getEdges(Node node) {
        return idToEdgeMap.get(node.getId());
    }

    /**
     * The setEdges method to set an Edges connected to node.
     *
     * @param node to set Edges in list for node.
     * @param edges to add all edges related to node.
     */
    public void setEdges(Node node, List<Edge> edges) {
        this.idToEdgeMap.put(node.getId(), edges);
    }

    /**
     * The addOrUpdateNode method is to add or update a Node in List.
     *
     * @param node to add or update node in list
     */
    public void addOrUpdateNode(Node node) {
        if(!idToNodeMap.containsKey(node.getId())){
            this.idToEdgeMap.put(node.getId(), new ArrayList<Edge>());
        }
        this.idToNodeMap.put(node.getId(), node);
    }

    /**
     * The addEdge method is to add edge in list and set type and end nodes based on node.
     *
     * @param type to set connection type between classes
     * @param startNode to set startNode of given edge
     * @param endNode to set endNode of given edge
     */
    public void addEdge(Relation type, Node startNode, Node endNode) {
        Edge edge = new Edge(type, startNode.getId(), endNode.getId());
        List<Edge> edges = idToEdgeMap.get(startNode.getId());
        edges.add(edge);
    }

    /**
     * The addEdge method is to add edge in list and set type and end nodes based on id.
     *
     * @param type to set connection type between classes
     * @param startNode to set startNode of given edge
     * @param endNode to set endNode of given edge
     */
    public void addEdge(Relation type, int startNode, int endNode) {
        Edge edge = new Edge(type, startNode, endNode);
        List<Edge> edges = idToEdgeMap.get(startNode);
        edges.add(edge);
    }

    /**
     * The getNodes method is to get nodes.
     *
     * @return List of nodes
     */
    public List<Node> getNodes() {
        return new ArrayList<>(idToNodeMap.values());
    }

    /**
     * The getEdges method is to get edges.
     *
     * @return List of edges
     */
    public List<Edge> getEdges() {
        List<Edge> completeEdgeList = new ArrayList<>();
        for (Collection<Edge> edgeList : idToEdgeMap.values()) {
            completeEdgeList.addAll(edgeList);
        }
        return completeEdgeList;
    }

}
