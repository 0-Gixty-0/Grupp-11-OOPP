package com.group11.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

/**
 * The highest level of abstraction for creating ViewDrawable objects.
 */
public abstract class AViewDrawableFactory {

    private static final int SCALE = 16; //The scale of the image, ex: 16 bit, 32 bit, 64 bit....

    /**
     * The method returns the coordinates of the terrain type id in the texture map file.
     * @param id The terrain type id
     * @return Point object containing the matrix coordinate of the terrain type id
     */
    protected abstract Point getTextureMatrixCoordinate(int id);

    /**
     * The method validates that the terrain type id is in a valid range.
     * @param id The terrain type id
     */
    protected abstract void validateTextureId(int id);

    /**
     * The method returns the texture map file as an ImageIcon.
     * @return ImageIcon containing the texture map file
     */
    protected abstract ImageIcon getTextureMapImageIcon();

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

        ImageIcon fullTexture = this.getTextureMapImageIcon();
        
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

    protected abstract AViewDrawable createDrawable(Integer id);

}
