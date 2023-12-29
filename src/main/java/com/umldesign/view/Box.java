package com.umldesign.view;
import com.umldesign.common.Constants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
 * This Class is used to draw box
 *
 * @author Praveen
 * @version 1.0
 */
public class Box implements Drawable{
		int x = 0;
		int y = 0;
		String name;
		static final int WIDTH = Constants.BOX_WIDTH;
		static final int HEIGHT = Constants.BOX_HEIGHT;
		static final int CONN_SIZE = 20;
	    
		/**
	     * Constructor method
	     * @param name The name of the box/class
	     * @param xpos The center x position of box
	     * @param ypos The center y position of box
	     */
		public Box(String name, int xpos, int ypos) {
			this.x = xpos;
			this.y = ypos;
			this.name = name;
		}
		
		/**
	     * getter method for x
	     * @return x coordinate
	     */
		public int getX() {
			return this.x;
		}
		
		/**
	     * getter method for y
	     * @return y coordinate
	     */
		public int getY() {
			return this.y;
		}
		
		/**
	     * getter method for name
	     *  @return name
	     */
		public String getName() {
			return this.name;
		}
		
		/**
	     * getter method for rectangle data for drawing rectangle
	     * @return coordinate, width and height of the rectangle
	     */
		public int[] getRectData(){
			return new int[] {x - WIDTH/2, y - HEIGHT/2, WIDTH, HEIGHT};
		}
		
		/**
	     * getter for the center point of area where connection (association, composition etc.) will be
	     * @param orientation The position where the connection will be
	     * @return coordinates of the connection box center
	     */
		public int[] getConnBoxCenter(Orientation orientation) {
			switch(orientation) {
				case LEFT:  return new int[] {x - WIDTH/2 - CONN_SIZE/2, y};
				case RIGHT:  return new int[] {x + WIDTH/2 + CONN_SIZE/2, y};
				case TOP:  return new int[] {x, y - HEIGHT/2 - CONN_SIZE/2};
				case BOTTOM:   return new int[] {x, y + HEIGHT/2 + CONN_SIZE/2};
				default: return new int[] {-1,-1};
			}
		}
		
		/**
	     * getter for the center point of area where the line connection
	     * @param orientation The position where the connection will be
	     * @return coordinates of the connection point
	     */
		public int[] getConnPoint(Orientation orientation) {
			switch(orientation) {
				case LEFT:  return new int[] {x - WIDTH/2 - CONN_SIZE, y};
				case RIGHT:  return new int[] {x + WIDTH/2 + CONN_SIZE, y};
				case TOP:  return new int[] {x, y - HEIGHT/2 - CONN_SIZE};
				case BOTTOM: return new int[] {x, y + HEIGHT/2 + CONN_SIZE};
				default: return new int[] {-1,-1};
			}
		}
		
		/**
	     * draws the box with name
	     * @param g The Graphics element
	     */
		@Override
		public void draw(Graphics g) {
			int[] data = this.getRectData();
			Graphics2D g2 = (Graphics2D)g;
			g.setColor( Color.decode("#ffffcd"));
			g.fillRect(data[0], data[1], data[2], data[3]);
			
			Font font = new Font("Serif", Font.BOLD, 15);
			 
			g2.setFont(font);
			g.setColor( Color.BLACK);
			g2.drawString(this.getName(), this.getX() - WIDTH/3, this.getY() - HEIGHT/3);
			
		}
		
}
