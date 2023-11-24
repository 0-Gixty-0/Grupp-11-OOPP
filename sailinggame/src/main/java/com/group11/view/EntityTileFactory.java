package com.group11.view;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.ImageIcon;

public class EntityTileFactory extends AViewTileFactory {

    @Override
    Point getTextureMatrixCoordinate(int id) {
        return new Point(0, id % 8);
    }

    @Override
    void validateTextureId(int id) {
        if (id < 0 || id > 7) {
            throw new IllegalArgumentException("Invalid terrain ID for entity tile");
        }
    }

    @Override
    ImageIcon getImageIcon() {
        return (new ImageIcon("sailinggame\\src\\main\\resources\\player_ship.png"));
    }
    
}
