package com.group11.view;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.ImageIcon;

public class TerrainTileFactory extends AViewTileFactory {
    
    static final int amountOfTerrainTypes = 2;

    @Override
    ViewTile createTile(int id, Dimension dimension, Point matrixPosition, Point pixelPosition) {
        this.validateTextureId(id);
        ImageIcon imageIcon = createImageIcon(id, dimension.width, dimension.height, 16);
        return new ViewTile(imageIcon, dimension, matrixPosition, pixelPosition);
    }

    @Override
    Point getTextureMatrixCoordinate(int id) {
        return new Point((int) Math.floor(id/4), id % 4);
    }

    @Override
    void validateTextureId(int id) {
        if (id < 0 || id > amountOfTerrainTypes) {
            throw new IllegalArgumentException("Invalid terrain ID for terrain tile");
        }
    }

    @Override
    ImageIcon getImageIcon() {
        return (new ImageIcon("sailinggame/src/main/resources/textureMapSailingGame.png"));
    }

}
