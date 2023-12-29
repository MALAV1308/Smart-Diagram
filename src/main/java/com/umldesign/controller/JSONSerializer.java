package com.umldesign.controller;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.umldesign.model.Edge;
import com.umldesign.model.Node;
import com.umldesign.model.Repository;
import java.util.List;
/**
 * The JSONSerializer class is responsible for serializing the json data.
 *
 * @author harishkumarsrinivasappa
 * @version 1.0
 */
public class JSONSerializer implements Serializer {
    /**
     * The serialize method takes the data from the repository, generates a json data and serializes it to string format.
     *
     * @return serialized data.
     */
    @Override
    public String serialize() {
        JsonObject responseData = new JsonObject();
        JsonArray nodesArray = new JsonArray();
        JsonArray edgesArray = new JsonArray();
        List<Node> nodes = Repository.getInstance().getNodes();
        List<Edge> edges = Repository.getInstance().getEdges();

        for(Node node : nodes){
            JsonObject nodeObj = new JsonObject();
            nodeObj.addProperty("name",node.getName());
            nodeObj.addProperty("id",node.getId());
            nodeObj.addProperty("xpos",node.getX());
            nodeObj.addProperty("ypos",node.getY());
            nodesArray.add(nodeObj);
        }

        for(Edge edge : edges){
            JsonObject edgeObj = new JsonObject();
            edgeObj.addProperty("relation",String.valueOf(edge.getType()));
            edgeObj.addProperty("fromId",edge.getStartNode());
            edgeObj.addProperty("toId",edge.getEndNode());
            edgesArray.add(edgeObj);
        }
        responseData.add("nodes",nodesArray);
        responseData.add("edges",edgesArray);
        return responseData.toString();
    }
}
