package com.group11.view;

import javax.swing.*;
import java.awt.*;

public class EntityTile extends AViewTile {
    /**
     * Constructor for creating objects of type tile.
     *
     * @param id             - terrain type number, must be between 0 - 15
     * @param dimension      - width and height of tile
     * @param matrixPosition - tile position in matrix (row, column)
     * @param pixelPosition  - tile position on window frame in x and y pixels
     */
    public EntityTile(int id, Dimension dimension, Point matrixPosition, Point pixelPosition) {
        super(id, dimension, matrixPosition, pixelPosition);
    }

    /**
     * Validates texture id input to constructor. Allows ints in range 0 - 8
     * @param id the texture id
     * @return the texture id
     */
    @Override
    protected int validateTextureID(int id) {
        if (id < 0 || id > 7) {
            throw new IllegalArgumentException("Invalid terrain ID for entity tile");
        } else {
            return id;
        }
    }

    /**
     * Gets the coordinates for a tile image in the texture map based on a tile id number.
     * Coordinates are (row, column) with values 0 - 3
     * @param id The id for terrain type.
     * @return The point coordinate in the texture map matrix (row, column)
     */
    @Override
    protected Point getTextureMatrixCoordinate(int id) {
        return new Point(0, id % 8);
    }

    /**
     * @return An image of the entity texture map
     */
    @Override
    protected Image createTextureImage() {
        ImageIcon fullTexture = new ImageIcon("sailinggame/src/main/resources/player_ship.png");
        return fullTexture.getImage();
    }
}
