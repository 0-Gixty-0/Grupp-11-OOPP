package com.group11.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;


/**
 * The class is an abstract factory for creating ViewTile objects.
 */
public abstract class AViewTileFactory {

    private static int tileWidth;
    private static int tileHeight;
    private static final int SCALE = 16; //The scale of the image, ex: 16 bit, 32 bit, 64 bit....

    /**
     * Set the tile dimensions to be used for creating the ViewTiles.
     * @param tileWidth The width of the tiles.
     * @param tileHeight The height of the tiles.
     */
    protected static void setTileDimensions(int tileWidth, int tileHeight) {
        AViewTileFactory.tileWidth = tileWidth;
        AViewTileFactory.tileHeight = tileHeight;
    }

    /**
     * Get the width of the tiles.
     * @return The width of the tiles.
     */
    protected static int getTileWidth() {
        return tileWidth;
    }

    /**
     * Get the height of the tiles.
     * @return The height of the tiles.
     */
    protected static int getTileHeight() {
        return tileHeight;
    }

    /**
     * The method creates the ImageIcon for a terrain type based on the texture map file.
     * The image icon is a scaled and sliced portion of the texture map based on the terrain type id
     * and desired width and height.
     * @param id The terrain type id
     * @param width The desired width of the image
     * @param height The desired height of the image
     * @return ImageIcon containing the tile image associated with the terrain type id
     */
    protected ImageIcon createImageIcon(int id, int width, int height) {

        ImageIcon fullTexture = this.getImageIcon();
        
        Image textureImage = fullTexture.getImage();
        
        Point textureMapMatrixPosition = this.getTextureMatrixCoordinate(id);

        Point textureMapPixelPosition = new Point(textureMapMatrixPosition.y * SCALE, textureMapMatrixPosition.x * SCALE);

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics g = bufferedImage.getGraphics();

        g.drawImage(textureImage, 0, 0, width, height, textureMapPixelPosition.x, textureMapPixelPosition.y,
                textureMapPixelPosition.x + SCALE, textureMapPixelPosition.y + SCALE, null);

        g.dispose();

        return new ImageIcon(bufferedImage);
    }

    /**
     * The method creates a ViewTile object based on the terrain type id, dimension, matrix position, and pixel position.
     * @param id The terrain type id
     * @param dimension The dimension of the tile
     * @param matrixPosition The matrix position of the tile
     * @return ViewTile object
     */
    protected ViewTile createTile(Integer id) {
        this.validateTextureId(id);
        Dimension dimension = new Dimension(tileWidth, tileHeight);
        ImageIcon imageIcon = createImageIcon(id, dimension.width, dimension.height);
        return new ViewTile(imageIcon, dimension);
    }

    /**
     * The method returns the coordinates of the terrain type id in the texture map file.
     * @param id The terrain type id
     * @return Point object containing the matrix coordinate of the terrain type id
     */
    abstract Point getTextureMatrixCoordinate(int id);

    /**
     * The method validates that the terrain type id is in a valid range.
     * @param id The terrain type id
     */
    abstract void validateTextureId(int id);

    /**
     * The method returns the texture map file as an ImageIcon.
     * @return ImageIcon containing the texture map file
     */
    abstract ImageIcon getImageIcon();
}
