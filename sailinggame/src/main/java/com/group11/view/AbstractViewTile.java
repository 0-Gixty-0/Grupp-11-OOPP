package com.group11.view;

import javax.swing.*;
import java.awt.*;

/**
 * Abstract class representing an abstract tile. Implements the drawable interface since
 * as tile is an object that is drawn on the screen.
 */
public abstract class AbstractViewTile implements Drawable {
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
    public AbstractViewTile(int id, Dimension dimension, Point matrixPosition, Point pixelPosition) {
        JLabel component = new JLabel(String.format("%d", id));
        component.setSize(dimension);
        component.setLocation(matrixPosition.y * dimension.width, matrixPosition.x * dimension.height);
        this.id = id;
        this.dimension = dimension;
        this.matrixPosition = matrixPosition;
        this.pixelPosition = pixelPosition;
        this.component = component;
    }

    public int getId() {
        return id;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public Point getMatrixPosition() {
        return matrixPosition;
    }

    public Point getPixelPosition() {
        return pixelPosition;
    }

    public JLabel getComponent() {
        return component;
    }
}
