package com.group11.view;

import javax.swing.*;
import java.awt.*;

/**
 * Tile class representing a tile for the view module.
 * Contains attributes for:
 * id - terrain type number
 * size - width and height of tile
 * matrixPosition - tile position in matrix (row, column)
 * pixelPosition - tile position on window frame in x and y pixels
 * component - JLabel component for use in rendering tile
 */
public class Tile extends AbstractTile {
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
    public Tile(int id, Dimension dimension, Point matrixPosition, Point pixelPosition) {
        super(id, dimension, matrixPosition, pixelPosition);
    }
}
