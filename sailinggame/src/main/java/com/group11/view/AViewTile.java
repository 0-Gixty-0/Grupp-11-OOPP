package com.group11.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Abstract class representing an abstract tile. Implements the drawable interface since
 * as tile is an object that is drawn on the screen.
 */
public abstract class AViewTile implements IDrawable {
    private int id;
    private Dimension dimension;
    private Point matrixPosition;
    private Point pixelPosition;
    private ImageIcon imageIcon;
    private JLabel component;

    /**
     * Constructor for creating objects of type tile.
     * @param id - terrain type number, must be between 0 - 15
     * @param dimension - width and height of tile
     * @param matrixPosition - tile position in matrix (row, column)
     * @param pixelPosition - tile position on window frame in x and y pixels
     */
    public AViewTile(int id, Dimension dimension, Point matrixPosition, Point pixelPosition) {
        if (id < 0 || id > 15) {
            throw new IllegalArgumentException("Invalid terrain ID");
        }
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

    /**
     * The method creates the ImageIcon for a terrain type based on the texture map file.
     * The image icon is a scaled and sliced portion of the texture map based on the terrain type id
     * and desired width and height.
     * @param id The terrain type id
     * @param width The desired width of the image
     * @param height The desired height of the image
     * @param scale The scale of the image, ex: 16 bit, 32 bit, 64 bit....
     * @return ImageIcon containing the tile image associated with the terrain type id
     */
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

    /**
     * Gets the coordinates for a tile image in the texture map based on a tile id number.
     * @param id The id for terrain type.
     * @return The point coordinate in the texture map matrix (row, column)
     */
     abstract Point getTextureMatrixCoordinate(int id);

    /**
     * Creates the JLabel component associated with a ViewTile. The JLabel component is what is
     * drawn to screen.
     * @param dimension The dimensions for the tile in (width, height) format
     * @param matrixPosition The matrix position of the tile in the world
     * @param imageIcon The imageIcon object containing the image to be drawn
     * @return A JLabel component for drawing the tile to the screen
     */
    private JLabel createComponent(Dimension dimension, Point matrixPosition, ImageIcon imageIcon) {
        JLabel component = new JLabel();
        component.setSize(dimension);
        component.setLocation(matrixPosition.y * dimension.width, matrixPosition.x * dimension.height);
        component.setIcon(imageIcon);
        return component;
    }
}
