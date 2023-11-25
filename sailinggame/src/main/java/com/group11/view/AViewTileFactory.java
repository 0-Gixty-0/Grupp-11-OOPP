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
    protected ImageIcon createImageIcon(int id, int width, int height, int scale) {

        ImageIcon fullTexture = this.getImageIcon();
        
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
     * The method creates a ViewTile object based on the terrain type id, dimension, matrix position, and pixel position.
     * @param id The terrain type id
     * @param dimension The dimension of the tile
     * @param matrixPosition The matrix position of the tile
     * @param pixelPosition The pixel position of the tile
     * @return ViewTile object
     */
    ViewTile createTile(int id, Dimension dimension, Point matrixPosition, Point pixelPosition) {
        this.validateTextureId(id);
        ImageIcon imageIcon = createImageIcon(id, dimension.width, dimension.height, 16);
        return new ViewTile(imageIcon, dimension, matrixPosition, pixelPosition);
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
