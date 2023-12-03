package com.group11.view;

import java.awt.Point;
import java.awt.Toolkit;


import javax.swing.ImageIcon;

public class TerrainTileFactory extends AViewTileFactory {

    protected TerrainTileFactory() {
        super(1);
    }

    @Override
    protected Point getTextureMatrixCoordinate(int id) {
        return new Point((int) Math.floor(id/4), id % 4);
    }

    @Override
    protected ImageIcon initTextureMapImageIcon() {
        return (new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/textureMapSailingGame.png"))));
    }

}
