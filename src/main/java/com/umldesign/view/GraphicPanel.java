package com.umldesign.view;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
/**
 * The GraphicPanel class is responsible for painting the drawables on the panel. It's also an observer observing
 * the repository for changes to repaint the panel.
 *
 * @author harishkumarsrinivasappa
 * @version 1.0
 */
public class GraphicPanel extends JPanel implements Observer {

    private TraversalStrategy traversalStrategy;
    /**
     * The GraphicPanel Constructor method is responsible for configuring the graphic panel UI.
     */
    public GraphicPanel(TraversalStrategy traversalStrategy){
        this.traversalStrategy = traversalStrategy;
        setPreferredSize(new Dimension(650,720));
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    }

    /**
     * The paintComponent method draws the panel with drawables using the graphics object.
     *
     * @param g the graphic object used for painting the drawables.
     */
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	TraversalData data = traversalStrategy.traverse();
    	for (Drawable drawable : data.getGraphicalData()) {
    		drawable.draw(g);
        }
    }

    /**
     * The reDrawGraphicPanel method repaints the entire panel.
     */
    public void reDrawGraphicPanel() {
    	repaint();
    }

    /**
     * The update is invoked when there is a change in the repository. We then redraw to update the UI.
     *
     * @param o observable object reference
     * @param arg additional arguments
     */
    @Override
    public void update(Observable o, Object arg) {
        reDrawGraphicPanel();
    }
}
