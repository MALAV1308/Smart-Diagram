package com.umldesign.view;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.umldesign.model.Edge;
import com.umldesign.model.Node;
import com.umldesign.model.Repository;
/**
 * GraphTraversalStrategy is implementation of TraversalStrategy to generate graphical representation to display.
 *
 * @author Aakash Vora
 * @version 1.0
 */

public class GraphTraversalStrategy implements TraversalStrategy {

    /**
     * Factory for generating UI objects
     */
	AbstractConnectionFactory connectionFactory;

    /**
     * The GraphTraversalStrategy constructor initializes the connection factory
     *
     * @param connectionFactory reference to the factory.
     */
    public GraphTraversalStrategy(AbstractConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /**
     * This method traverse the repository nodes and creates drawables.
     *
     * @return traversal data containing drawables.
     */
    @Override
    public TraversalData traverse() {
        List<Drawable> drawables = new ArrayList<>();
        Map<Integer,Box> idToBoxMap = new HashMap<>();
        List<Node> nodes = Repository.getInstance().getNodes();
        for (Node node : nodes) {
            Box box = new Box(node.getName(), node.getX(), node.getY());
            idToBoxMap.put(node.getId(), box);
            drawables.add(box);
        }
        List<Edge> edges = Repository.getInstance().getEdges();
        for (Edge edge : edges) {
            Box box1 = idToBoxMap.get(edge.getStartNode());
            Box box2 = idToBoxMap.get(edge.getEndNode());

            Drawable connection = connectionFactory.getConnection(edge.getType(),box1,box2);
            drawables.add(connection);
        }
        return new TraversalData(drawables);
    }

}
