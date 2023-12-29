package com.umldesign.model;
/**
 * The Node class is responsible for storing class information.
 *
 * @author Deven Prajapati
 * @version 1.0
 */
public class Node {
    private int id;
    private String name = "";
    private int x, y;
    /**
     * The Node constructor initializes the Node.
     */
    public Node(int id, String name, int x, int y) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
    }
    /**
     * The getId method is to get id of node.
     *
     * @return id of node.
     */
    public int getId() {
        return id;
    }

    /**
     * The setId method is to set id of Node.
     *
     * @param id of node to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * The getName method is to get name of node.
     *
     * @return name of node as string.
     */
    public String getName() {
        return name;
    }

    /**
     * The setName method is to set name of Node.
     *
     * @param name of node to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The getName method is to get name of node.
     *
     * @return name of node as string.
     */
    public int getX() {
        return x;
    }

    /**
     * The setX method is x coordinate of Node.
     *
     * @param x coordinate of node.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * The getY method is y coordinate of Node.
     *
     * @return y coordinate of node.
     */
    public int getY() {
        return y;
    }

    /**
     * The setY method is y coordinate of Node.
     *
     * @param y coordinate of node.
     */
    public void setY(int y) {
        this.y = y;
    }
}
