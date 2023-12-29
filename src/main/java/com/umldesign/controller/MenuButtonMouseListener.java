package com.umldesign.controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * The MenuButtonMouseListener class is responsible for positioning the popupmenu when the user clicks on the menu button.
 *
 * @author harishkumarsrinivasappa
 * @version 1.0
 */
public class MenuButtonMouseListener extends MouseAdapter {
    private JPopupMenu menu;
    private JButton button;
    /**
     * The MenuButtonMouseListener constructor is responsible for initializing the popupmenu and menu button.
     *
     * @param menu the popup menu.
     * @param button the menu button.
     */
    public MenuButtonMouseListener(JPopupMenu menu, JButton button){
        this.menu = menu;
        this.button = button;
    }
    /**
     * The mousereleased method is used for position the popup menu on click action over menu button.
     *
     * @param e mouse event object.
     */
    public void mouseReleased(MouseEvent e){
        if ( e.getButton() == 1 ){
            Component b=(Component)e.getSource();
            Point p=b.getLocationOnScreen();
            menu.show(button,0,0);
            menu.setLocation(p.x+5,p.y+b.getHeight());
        }
    }
}
