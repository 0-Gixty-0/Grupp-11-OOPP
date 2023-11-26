package com.group11.view;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Class reresenting something that can be displayed on the screen by the view. 
 */
public abstract class AViewDrawable extends JLabel {
    /**
     * Constructor for the AViewDrawable class.
     * @param imageIcon The image icon to be displayed on the tile
     * @param dimension The dimension of the tile
     * @param matrixPosition The matrix position of the tile
     */
    protected AViewDrawable(ImageIcon imageIcon, Dimension dimension) {
        super();
        this.setSize(dimension);
        this.setIcon(imageIcon);
    }   
}
