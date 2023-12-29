package com.umldesign.controller;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.umldesign.common.Relation;
import com.umldesign.model.RepositoryService;
/**
 * The JSONDeserializer class is responsible for deserializing the json data.
 *
 * @author harishkumarsrinivasappa
 * @version 1.0
 */
public class JSONDeserializer implements Deserializer {
    private RepositoryService service;
    /**
     * The JSONDeserializer constructor takes in the repository service which is used to write the data to the repository.
     *
     * @param service the repository service.
     */
    public JSONDeserializer(RepositoryService service) {
        this.service = service;
    }
    /**
     * The deserialize method is used to deserialize the json data and write it to the repository.
     *
     * @param data to be deserialized.
     */
    @Override
    public void deserialize(String data) {
        JsonObject graphData = (JsonObject) JsonParser.parseString(data);
        JsonArray nodes = graphData.getAsJsonArray("nodes");
        JsonArray edges = graphData.getAsJsonArray("edges");

        service.resetData();

        for(JsonElement element : nodes){
            JsonObject node = (JsonObject) element;
            String name = node.get("name").getAsString();
            int xpos = node.get("xpos").getAsInt();
            int ypos = node.get("ypos").getAsInt();
            int id = node.get("id").getAsInt();
            service.addBox(id,name, xpos, ypos);
        }

        for(JsonElement element : edges){
            JsonObject edge = (JsonObject) element;
            String rel = edge.get("relation").getAsString();
            int fromId = edge.get("fromId").getAsInt();
            int toId = edge.get("toId").getAsInt();
            service.addConnection(Relation.valueOf(rel),fromId,toId);
        }
    }
}
