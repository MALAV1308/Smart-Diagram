package com.umldesign.view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
 * Connection class is an abstract class needs to be used by all connection implementation
 *  between two boxes.
 *  Contains implementation of useful methods which is needed when implementing 
 *  any concrete connection class.
 *
 * @author Praveen
 * @version 1.0
 */
abstract class Connection implements Drawable{
	Box boxStart;
	Box boxEnd;
	
	protected static final int CONN_SIZE = 20;

	/**
	 * draw abstract method help to draw using graphics obj.
	 *
	 * @param g The Graphics element
	 */
	public abstract void draw(Graphics g);

	/**
	 * Connection constructor initializes the box values.
	 *
	 * @param boxStart reference to box
	 * @param boxEnd reference to box
	 */
	public Connection(Box boxStart, Box boxEnd){
		this.boxStart = boxStart;
		this.boxEnd = boxEnd;
	}


	/**
     * This method gives the position where the connections between two boxes needs to be made
     * based on their relative position
     *
     * @param boxStart The box where the connection starts
     * @param boxEnd   The box where the connection terminates
     * @return returns the orientations of the connection area
     */
	protected Orientation[] getConnectionOrientation(Box boxStart, Box boxEnd) {
		int deltaX = boxStart.getX() - boxEnd.getX();
		int deltaY = boxStart.getY() - boxEnd.getY();
		int[] aConnPt;
		int[] bConnPt;

		if(boxStart == boxEnd) {
			return new Orientation[] {Orientation.RIGHT, Orientation.TOP};
		}
		
		if(Math.abs(deltaX) < Math.abs(deltaY)) {
			if(deltaY < 0) {
				return new Orientation[] {Orientation.BOTTOM, Orientation.TOP};
			}else {
				return new Orientation[] {Orientation.TOP, Orientation.BOTTOM};
			}
		}else {
			if(deltaX > 0) {
				return new Orientation[] {Orientation.LEFT, Orientation.RIGHT};
			}else {
				return new Orientation[] {Orientation.RIGHT, Orientation.LEFT};
			}
		}
	}
	
    /**
     * This method rotates the graphics on which the connection will be drawn. This can be
     * used to draw connection facing different directions.
     *
     * @param g The graphics2D object which will be rotated
     * @param x The center coordinate's x value about which the graphics will be rotated
     * @param y The center coordinate's y value about which the graphics will be rotated
     * @param o The direction to which the graphics needs to be rotated
     */
	protected void rotateBasedOnOrientation(Graphics2D g, int x, int y, Orientation o) {
		switch(o) {
			case LEFT:  break;
			case RIGHT:  g.rotate(Math.toRadians(180), x, y); break;
			case TOP:  g.rotate(Math.toRadians(90), x, y); break;
			case BOTTOM:  g.rotate(Math.toRadians(270), x, y); break;
		}
	}
	
	
    /**
     * This method rotates the graphics to negate the rotateBasedOnOrientation method's effect. 
     *
     * @param g The graphics2D object which will be rotated
     * @param x The center coordinate's x value about which the graphics will be rotated
     * @param y The center coordinate's y value about which the graphics will be rotated
     * @param o The direction to which the graphics was previously rotated
     */
	protected void resetRotationBasedOnOrientation(Graphics2D g, int x, int y, Orientation o) {
		switch(o) {
			case LEFT:  break;
			case RIGHT:  g.rotate(Math.toRadians(180), x, y); break;
			case TOP:  g.rotate(Math.toRadians(270), x, y); break;
			case BOTTOM:  g.rotate(Math.toRadians(90), x, y); break;
		}
	}
	
    /**
     * This method draws a straight line between two points
     *
     * @param g2d The graphics2D on which line will be drawn
     * @param point1 starting point
     * @param point2 ending point
     */
	protected void drawLine(Graphics2D g2d, int[] point1, int[] point2) {
		g2d.setColor(Color.BLACK);
		g2d.drawLine(point1[0], point1[1], point2[0], point2[1]);
	}
	
}
