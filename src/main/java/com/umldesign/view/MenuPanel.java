package com.umldesign.view;
import com.umldesign.controller.MenuButtonMouseListener;
import javax.swing.*;
import java.awt.*;

/**
 * The MenuPanel holds the menu buttons used for loading, saving and new actions.
 *
 * @author harishkumarsrinivasappa
 * @version 1.0
 */
public class MenuPanel extends JPanel {

    /**
     * The MenuPanel constructor is responsible for configuring the menu panel UI.
     */
    public MenuPanel(){
        setPreferredSize(new Dimension(1000,50));
        setLayout(new FlowLayout(3));
    }

    /**
     * The add menu button adds the menu button to the menu panel.
     *
     * @param name of the menu button
     * @param width width of the menu button
     * @param height height of the menu button
     * @param menu popupmenu displayed on mouse click actions.
     */
    public void addMenuButton(String name, int width, int height, JPopupMenu menu){
        JButton menuButton = new JButton(name);
        menuButton.setPreferredSize(new Dimension(width,height));
        menuButton.addMouseListener(new MenuButtonMouseListener(menu,menuButton));
        add(menuButton);
    }
}
