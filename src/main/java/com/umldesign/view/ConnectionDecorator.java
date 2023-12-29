package com.umldesign.view;
import java.awt.Graphics;
/**
 * This abstract class needs to be implemented by all different concrete connection decorator
 *  like association, composition etc.
 * @author Praveen
 * @version 1.0
 */
abstract class ConnectionDecorator extends Connection{
	
	protected Connection connection;

	/**
	 * ConnectionDecorator constructor initializes the box values.
	 *
	 * @param boxStart reference to box
	 * @param boxEnd reference to box
	 */
	public ConnectionDecorator(Box boxStart, Box boxEnd) {
		super(boxStart, boxEnd);
	}
	
    /**
     * This method sets the element to which this decoration will be added
     * @param connection The connection element to which the decoration will be added
     */
	public void setComponent(Connection connection) {
		this.connection = connection;
	}
	
    /**
     * This method draws the base element if present
     * @param g The Graphics element
     */
	@Override
	public void draw(Graphics g) {
		if(connection != null) {
			connection.draw(g);
		}
	}
	

	
	
}
