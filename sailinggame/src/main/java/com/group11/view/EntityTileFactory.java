package com.group11.view;

import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * The class is a factory for creating ViewTile objects representing entities.
 */
public class EntityTileFactory extends AViewTileFactory {

    /**
     * The amount of entity textures in the texture map. Calculated like ENTITYTEXTURES = (amount of textures in texture map) - 1
     */
    private static final int ENTITYTEXTURES = 7;
    
    @Override
    Point getTextureMatrixCoordinate(int id) {
        return new Point(0, id % 8);
    }

    @Override
    void validateTextureId(int id) {
        if (id < 0 || id > ENTITYTEXTURES) {
            throw new IllegalArgumentException("Invalid terrain ID for entity tile");
        }
    }

    @Override
    ImageIcon getImageIcon() {
        return (new ImageIcon("sailinggame\\src\\main\\resources\\player_ship.png"));
    }
    
}
