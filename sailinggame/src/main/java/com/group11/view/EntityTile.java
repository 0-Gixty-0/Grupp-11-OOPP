package com.group11.view;

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
     * Gets the coordinates for a tile image in the texture map based on a tile id number.
     * Coordinates are (row, column) with values 0 - 3
     * @param id The id for terrain type.
     * @return The point coordinate in the texture map matrix (row, column)
     */
    @Override
    Point getTextureMatrixCoordinate(int id) {
        return new Point((int) Math.floor(id/4), id % 4);
    }
}
