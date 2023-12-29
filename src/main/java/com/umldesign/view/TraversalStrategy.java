package com.umldesign.view;
/**
 * TraversalStrategy is a interface for traversing the graph and generating the output.
 *
 * @author Aakash Vora
 * @version 1.0
 */
public interface TraversalStrategy {
    /**
     * Traverse the graph and generates the representation
     * 
     * @return TraversalData objects containing information
     */
    public TraversalData traverse();
}
