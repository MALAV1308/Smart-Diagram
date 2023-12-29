package com.umldesign.view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * This Class Decorates the connection with inheritance decoration
 *
 * @author Praveen
 * @version 1.0
 */
public class LineConnection extends Connection{
	
    /**
     * This method draws the line between two boxes
     * @param g The Graphics element
     */
	@Override
	public void draw(Graphics g) {

		int[] conn = this.getLineData();

		g.setColor(Color.BLACK);
		g.drawLine(conn[0], conn[1], conn[2], conn[3]);
		
		Orientation[] connectionOrientations = getConnectionOrientation(boxStart,boxEnd);
		int[] connectionPoint = boxStart.getConnBoxCenter(connectionOrientations[0]);
		
		Graphics2D g2d = (Graphics2D) g;
		rotateBasedOnOrientation(g2d,connectionPoint[0],connectionPoint[1],connectionOrientations[0]);
		g.setColor(Color.BLACK);
		g2d.drawLine(connectionPoint[0] - CONN_SIZE/2, connectionPoint[1], connectionPoint[0] + CONN_SIZE/2, connectionPoint[1]);
		resetRotationBasedOnOrientation(g2d,connectionPoint[0],connectionPoint[1],connectionOrientations[0]);
	}
	
    /**
     * Constructor method
     * @param boxStart box from which line starts
     * @param boxEnd box at which line terminates
     */
	public LineConnection(Box boxStart, Box boxEnd) {
		super(boxStart, boxEnd);
	}
	
	
    /**
     * Generates the starting and ending x,y coordinates of the line connection
     * @return The coordinates of the line
     */
	public int[] getLineData() {
		int deltaX = boxStart.getX() - boxEnd.getX();
		int deltaY = boxStart.getY() - boxEnd.getY();
		int[] aConnPt;
		int[] bConnPt;
		Orientation[] orientations = getConnectionOrientation(boxStart,boxEnd);
		aConnPt = boxStart.getConnPoint(orientations[0]);
		bConnPt = boxEnd.getConnPoint(orientations[1]);

		return new int[] {aConnPt[0], aConnPt[1], bConnPt[0], bConnPt[1]};
	}
}
