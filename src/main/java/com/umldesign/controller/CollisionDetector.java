package com.umldesign.controller;
/**
 * CollisionDetector interfaces is used to represent method for collision detection.
 *
 * @author Aakash Vora
 * @version 1.0
 */
public interface CollisionDetector {
    /**
     * @param x X co-ordinate
     * @param y Y co-ordinate
     * @return id of the node where collision occurred, -1 if no collision
     */
    public int detectCollision(int x,int y);
}
