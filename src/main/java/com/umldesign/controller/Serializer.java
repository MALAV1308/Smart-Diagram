package com.umldesign.controller;
/**
 * Serializer interface enforces the serialize behaviour in the classes that implement it.
 *
 * @author harishkumarsrinivasappa
 * @version 1.0
 */
public interface Serializer {
    /**
     * The serialize method serializes the repository data and returns it in string format.
     *
     * @return the serialized data.
     */
    public String serialize();
}
