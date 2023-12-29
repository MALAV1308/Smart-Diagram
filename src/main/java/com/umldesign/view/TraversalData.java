package com.umldesign.view;
import java.util.List;

/**
 * POJO for storing traversal data.
 *
 * @author Aakash Vora
 * @version 1.0
 */

public class TraversalData {

    /**
     * Stores textual representation of the graph
     */
    private String textData;
    /**
     * Stores graphical representation of the graph
     */
    private List<Drawable> graphicalData;

    public TraversalData(List<Drawable> graphicalData) {
        this.graphicalData = graphicalData;
    }
    public TraversalData(String textData) {
        this.textData = textData;
    }

    /**
     * @return Returns Textual representation
     */
    public String getTextData() {
        return textData;
    }

    /**
     * @param textData Set textual representation
     */
    public void setTextData(String textData) {
        this.textData = textData;
    }
    
    /**
     * @return Returns list of drawables
     */
    public List<Drawable> getGraphicalData() {
        return graphicalData;
    }
    /**
     * @param graphicalData List of Drawable
     */
    public void setGraphicalData(List<Drawable> graphicalData) {
        this.graphicalData = graphicalData;
    }
}
