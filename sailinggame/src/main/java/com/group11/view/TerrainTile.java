package com.group11.view;

import javax.swing.*;
import java.awt.*;

/**
 * Tile class representing a tile for the View module.
 * ViewTile class representing a tile for the view module.
 * Contains attributes for:
 * id - terrain type number
 * size - width and height of tile
 * matrixPosition - tile position in matrix (row, column)
 * pixelPosition - tile position on window frame in x and y pixels
 * component - JLabel component for use in rendering tile
 */
public class TerrainTile extends AViewTile {
    private int id;
    private Dimension dimension;
    private Point matrixPosition;
    private Point pixelPosition;
    private JLabel component;

    /**
     * Constructor for creating objects of type tile.
     * @param id - terrain type number
     * @param dimension - width and height of tile
     * @param matrixPosition - tile position in matrix (row, column)
     * @param pixelPosition - tile position on window frame in x and y pixels
     */
    public TerrainTile(int id, Dimension dimension, Point matrixPosition, Point pixelPosition) {
        super(id, dimension, matrixPosition, pixelPosition);
    }

    /**
     * Validates texture id input to constructor. Allows ints in range 0 - 15
     * @param id the texture id
     * @return the texture id
     */
    @Override
    protected int validateTextureID(int id) {
        if (id < 0 || id > 15) {
            throw new IllegalArgumentException("Invalid terrain ID for terrain tile");
        } else {
            return id;
        }
    }

    /**
     * Gets the coordinates for a tile image in the texture map based on a tile id number.
     * Coordinates are (row, column) with values 0 - 3
     *
     * @param id The id for terrain type.
     * @return The point coordinate in the texture map matrix (row, column)
     */
    @Override
    protected Point getTextureMatrixCoordinate(int id) {
        return new Point((int) Math.floor(id/4), id % 4);
    }

    /**
     * @return An image of the terrain texture map
     */
    @Override
    protected Image createTextureImage() {
        ImageIcon fullTexture = new ImageIcon("sailinggame/src/main/resources/textureMapSailingGame.png");
        return fullTexture.getImage();
    }
}
