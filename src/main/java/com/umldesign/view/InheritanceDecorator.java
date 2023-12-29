package com.umldesign.view;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
 * This Class Decorates the connection with inheritance decoration
 *
 * @author Praveen
 * @version 1.0
 */
public class InheritanceDecorator extends ConnectionDecorator{
    /**
     * This method draws the inheritance connection at boxEnd
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
		
		rotateBasedOnOrientation(g2d,x,y,connectionOrientations[1]);
		drawLine(g2d, p1, p2);
		drawLine(g2d, p1, p3);
		drawLine(g2d, p2, p3);
		resetRotationBasedOnOrientation(g2d,x,y,connectionOrientations[1]);
	}
	
    /**
     * Constructor method
     * @param boxStart The box where the connection starts
     * @param boxEnd The box where the connection terminates
     */
	public InheritanceDecorator(Box boxStart, Box boxEnd) {
		super(boxStart, boxEnd);
	}
}
