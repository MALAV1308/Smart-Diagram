package com.umldesign.controller;
import java.util.List;
import com.umldesign.common.Constants;
import com.umldesign.model.Node;
import com.umldesign.model.Repository;

/**
 * ConcreteCollisionDetector implements CollisionDetector interface.
 *
 * @author Aakash Vora
 * @version 1.0
 */
public class ConcreteCollisionDetector implements CollisionDetector {

    /**
     * The detect collision method takes in x and y coordinates and return the node id if the x,y coordinate comes under
     * that node. If not it returns -1.
     *
     * @param x x coordinate on screen
     * @param y y coordinate on screen
     * @return node id
     */
    @Override
    public int detectCollision(int x, int y) {
        List<Node> nodes = Repository.getInstance().getNodes();
        for (Node node : nodes) {
            int xLeft = node.getX() - Constants.BOX_WIDTH / 2;
            int xRight = node.getX() + Constants.BOX_WIDTH / 2;
            int yUp = node.getY() - Constants.BOX_HEIGHT / 2;
            int yDown = node.getY() + Constants.BOX_HEIGHT / 2;
            if (x >= xLeft && x <= xRight && y >= yUp && y <= yDown) return node.getId();
        }
        return -1;
    }
    
}
