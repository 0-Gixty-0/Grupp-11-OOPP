package com.group11.view.uicomponents;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Class representing a tile that can be displayed on the screen by the view.
 */
public class ViewTile extends JLabel {

    /**
     * Constructor for the ViewTile class.
     * @param imageIcon The image icon to be displayed on the tile
     * @param dimension The dimension of the tile
     */
    public ViewTile(ImageIcon imageIcon, Dimension dimension) {
        super();
        this.setSize(dimension);
        this.setIcon(imageIcon);
    }
}