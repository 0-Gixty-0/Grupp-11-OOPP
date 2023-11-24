package com.group11.view;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ViewTile extends JLabel {
    
    protected ViewTile(ImageIcon imageIcon, Dimension dimension, Point matrixPosition, Point pixelPosition) {
        super();
        this.setSize(dimension);
        this.setLocation(matrixPosition.y * dimension.width, matrixPosition.x * dimension.height);
        this.setIcon(imageIcon);
    }   
    
    
}
