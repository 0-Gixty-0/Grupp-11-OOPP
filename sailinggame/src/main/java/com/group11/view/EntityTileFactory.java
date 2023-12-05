package com.group11.view;

import java.awt.Point;
import java.awt.Toolkit;


import javax.swing.ImageIcon;

/**
 * The class is a factory for creating ViewTile objects representing entities.
 */
public class EntityTileFactory extends AViewTileFactory {

    protected EntityTileFactory() {
        super(7);
    } 

    @Override
    protected Point getTextureMatrixCoordinate(int id) {
        return new Point(0, id % 8);
    }

    @Override
    protected ImageIcon initTextureMapImageIcon() {
        return (new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/entityTextureMap.png"))));
    }

}