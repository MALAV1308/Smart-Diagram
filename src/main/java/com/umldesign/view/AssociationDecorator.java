package com.umldesign.view;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
 * This Class Decorates the connection with association decoration
 *
 * @author Praveen
 * @version 1.0
 */
class AssociationDecorator extends ConnectionDecorator{	
    /**
     * This method draws the association connection at boxEnd
     * @param g The Graphics element
     */
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		Orientation[] connectionOrientations = getConnectionOrientation(boxStart,boxEnd);
		int[] connectionPoint = boxEnd.getConnBoxCenter(connectionOrientations[1]);

		Graphics2D g2d = (Graphics2D) g;
		int x = connectionPoint[0];
		int y = connectionPoint[1];
		int[] p1 = new int[] { x + CONN_SIZE / 2, y };
		int[] p2 = new int[] { x - CONN_SIZE / 2, y - CONN_SIZE / 2 };
		int[] p3 = new int[] { x - CONN_SIZE / 2, y + CONN_SIZE / 2 };
		int[] p4 = new int[] { x - CONN_SIZE / 2, y };
		
		rotateBasedOnOrientation(g2d,x,y,connectionOrientations[1]);
		drawLine(g2d, p2, p1);
		drawLine(g2d, p4, p1);
		drawLine(g2d, p3, p1);
		resetRotationBasedOnOrientation(g2d,x,y,connectionOrientations[1]);
	}
		
    /**
     * Constructor method
     * @param boxStart The box where the connection starts
     * @param boxEnd The box where the connection terminates
     */
	public AssociationDecorator(Box boxStart, Box boxEnd) {
		super(boxStart, boxEnd);
	}
}
