package com.group11.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Abstract class representing an abstract tile. Implements the drawable interface since
 * as tile is an object that is drawn on the screen.
 */
public abstract class AbstractViewTile implements Drawable {
    private int id;
    private Dimension dimension;
    private Point matrixPosition;
    private Point pixelPosition;
    private ImageIcon imageIcon;
    private JLabel component;

    /**
     * Constructor for creating objects of type tile.
     * @param id - terrain type number
     * @param dimension - width and height of tile
     * @param matrixPosition - tile position in matrix (row, column)
     * @param pixelPosition - tile position on window frame in x and y pixels
     */
    public AbstractViewTile(int id, Dimension dimension, Point matrixPosition, Point pixelPosition) {
        this.id = id;
        this.dimension = dimension;
        this.matrixPosition = matrixPosition;
        this.pixelPosition = pixelPosition;
        this.imageIcon = this.createImageIcon(id, dimension.width, dimension.height, dimension.width);
        this.component = this.createComponent(dimension, matrixPosition, this.imageIcon);
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

    private ImageIcon createImageIcon(int id, int width, int height, int scale) {
        ImageIcon fullTexture = new ImageIcon("sailinggame/src/main/resources/textureMapSailingGame.png");
        Image textureImage = fullTexture.getImage();

        Point textureMapMatrixPosition = this.getTextureMatrixCoordinate(id);
        Point textureMapPixelPosition = new Point(textureMapMatrixPosition.y * scale, textureMapMatrixPosition.x * scale);

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = bufferedImage.getGraphics();
        g.drawImage(textureImage, 0, 0, width, height, textureMapPixelPosition.x, textureMapPixelPosition.y,
                textureMapPixelPosition.x + scale, textureMapPixelPosition.y + scale, null);
        g.dispose();

        return new ImageIcon(bufferedImage);
    }

    private Point getTextureMatrixCoordinate(int id) {
        return new Point((int) Math.floor(id/4), id % 4);
    }

    private JLabel createComponent(Dimension dimension, Point matrixPosition, ImageIcon imageIcon) {
        JLabel component = new JLabel();
        component.setSize(dimension);
        component.setLocation(matrixPosition.y * dimension.width, matrixPosition.x * dimension.height);
        component.setIcon(imageIcon);
        return component;
    }
}
