package com.umldesign.controller;
/**
 * The Deserializer interface is used to enforce the deserialize behaviour on classes that implement it.
 *
 * @author harishkumarsrinivasappa
 * @version 1.0
 */
public interface Deserializer {
    /**
     * The deserialize method deserializes the data passed and updates the repository.
     *
     * @param data to be deserialized.
     */
    public void deserialize(String data);
}
