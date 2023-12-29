package com.umldesign.view;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.umldesign.common.Relation;
import com.umldesign.model.*;
/**
 * TextTraversalStrategy is implementation of TraversalStrategy to generate textual representation of string.
 *
 * @author Aakash Vora
 * @version 1.0
 */

public class TextTraversalStrategy implements TraversalStrategy {

    /**
     * This method traverses the repository nodes and creates the code in text format.
     *
     * @return the traversal data.
     */
    @Override
    public TraversalData traverse() {
        String text = "";
        List<String> nodeToStr = new ArrayList<>();
        List<Node> nodes = Repository.getInstance().getNodes();
        for (Node node : nodes) {
            nodeToStr.add(processNode(node));
        }
        text = String.join("\n", nodeToStr);
        return new TraversalData(text);
    }

    /**
     * Takes a node and adds information about it's connections
     * @param node Node in the graph
     * @return Textual representation
     */
    private String processNode(Node node) {
        Map<Relation,String> connectionStr = processConnection(Repository.getInstance().getEdges(node));
        String nodeStr = "class ";
        nodeStr += node.getName();
        nodeStr += connectionStr.get(Relation.INHERITENCE);
        nodeStr += " {\n";
        nodeStr += connectionStr.get(Relation.COMPOSITION);
        nodeStr += connectionStr.get(Relation.ASSOCIATION);
        nodeStr += "}";
        return nodeStr;
    }

    /**
     * Helper method for representing the connections
     * @param edges List of Connections
     * @return Map of relations and it's textual representation
     */
    private Map<Relation,String> processConnection(List<Edge> edges) {
        Map<Relation,String> connectionMap = new HashMap<>();
        for (Edge edge : edges) {
            String connectionStr = "";
            Relation type = edge.getType();
            if(connectionMap.containsKey(type)) {
                connectionStr = connectionMap.get(type);
            } 
            if(type == Relation.INHERITENCE) {
                connectionStr+= ((!connectionStr.isEmpty() ? ", " : "") + Repository.getInstance().getNodeById(edge.getEndNode()).getName());
            } else if (type == Relation.ASSOCIATION) {
                connectionStr+= ("\t\t" + Repository.getInstance().getNodeById(edge.getEndNode()).getName() + "\n");

            } else {
                connectionStr+= ("\t" + Repository.getInstance().getNodeById(edge.getEndNode()).getName() + "\n");
            }
            connectionMap.put(type, connectionStr);
        }
        for (Relation type : Relation.values()) {
            if(connectionMap.containsKey(type)) {
                String str = connectionMap.get(type);
                if(type == Relation.INHERITENCE) {
                    connectionMap.put(type, " extends " + str);
                } else if (type == Relation.COMPOSITION) {
                    connectionMap.put(type, "\n" + str);
                } else {
                    connectionMap.put(type, "\n\tmethod() {\n" + str + "\t}\n");
                }
            } else {
                connectionMap.put(type, "");
            }
        }
        return connectionMap;
    }
    
}
