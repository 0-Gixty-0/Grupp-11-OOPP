package com.group11.view;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Class reresenting a tile that can be displayed on the screen by the view. 
 */
public class ViewTile extends JLabel {
    
    /**
     * Constructor for the ViewTile class.
     * @param imageIcon The image icon to be displayed on the tile
     * @param dimension The dimension of the tile
     * @param matrixPosition The matrix position of the tile
     * @param pixelPosition The pixel position of the tile
     */
    protected ViewTile(ImageIcon imageIcon, Dimension dimension, Point matrixPosition, Point pixelPosition) {
        super();
        this.setSize(dimension);
        this.setLocation(matrixPosition.y * dimension.width, matrixPosition.x * dimension.height);
        this.setIcon(imageIcon);
    }   
    
    
}
