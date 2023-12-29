package com.umldesign.view;
import java.awt.Graphics;
/**
 * The base interface for all drawable elements(Eg: box, lines etc.) in the UI.
 * @author Praveen
 * @version 1.0
 */
public interface Drawable {
	/**
     * draw the UI element
     * @param g The Graphics element
     */
    public void draw(Graphics g);
}
