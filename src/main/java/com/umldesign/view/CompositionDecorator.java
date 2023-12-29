package com.umldesign.view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
/**
 * This Class Decorates the connection with composition decoration
 *
 * @author Praveen
 * @version 1.0
 */
public class CompositionDecorator extends ConnectionDecorator{
	
    /**
     * This method draws the composition connection at boxEnd
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
	
		int[] p1 = new int[] { x - CONN_SIZE / 2, y};
		int[] p2 = new int[] { x + CONN_SIZE / 2, y};
		int[] p3 = new int[] { x, y - CONN_SIZE / 2};
		int[] p4 = new int[] { x, y + CONN_SIZE / 2};
		Polygon p=new Polygon();

        p.addPoint(p1[0],p1[1]);
        p.addPoint(p3[0],p3[1]);
        p.addPoint(p2[0],p2[1]);
        p.addPoint(p4[0],p4[1]);
        p.addPoint(p1[0],p1[1]);
        g2d.setColor(Color.BLACK);
        g2d.fillPolygon(p);

	}
	
    /**
     * Constructor method
     * @param boxStart The box where the connection starts
     * @param boxEnd The box where the connection terminates
     */
	public CompositionDecorator(Box boxStart, Box boxEnd) {
		super(boxStart, boxEnd);
	}
}
