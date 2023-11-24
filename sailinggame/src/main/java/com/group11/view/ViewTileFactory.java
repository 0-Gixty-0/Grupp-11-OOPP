package com.group11.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class ViewTileFactory {
    
    /**
     * The amount of terrain types in the terrain texture map,
     * this is really necessary since we use the same texture map for entities and on for terrain
     */
    static final int amountOfTerrainTypes = 2;

    private ViewTileFactory() {
        throw new IllegalStateException("Utility class");
    }

    protected static ViewTile createTile(int id, Dimension dimension, Point matrixPosition, Point pixelPosition) {
        validateTextureId(id);
        ImageIcon imageIcon = createImageIcon(id, dimension.width, dimension.height, 16);
        return new ViewTile(imageIcon, dimension, matrixPosition, pixelPosition);
    }

    private static Point getEntityTextureMatrixCoordinate(int id) {
        return new Point(0, id % 8);
    }

    private static Point getTerrainTextureMatrixCoordinate(int id) {
        return new Point((int) Math.floor(id/4), id % 4);
    }

    private static void validateTextureId(int id) {
        if (id < 0 || id > 10) {
            throw new IllegalArgumentException("Invalid terrain ID for terrain tile");
        }
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
    private static ImageIcon createImageIcon(int id, int width, int height, int scale) {

        ImageIcon fullTexture;

        if (id < amountOfTerrainTypes) {fullTexture = new ImageIcon("sailinggame/src/main/resources/textureMapSailingGame.png");}
        else {fullTexture = new ImageIcon("sailinggame/src/main/resources/player_ship.png");}
        
        Image textureImage = fullTexture.getImage();

        Point textureMapMatrixPosition;
        
        if (id < 2) {textureMapMatrixPosition = getTerrainTextureMatrixCoordinate(id);}
        else {textureMapMatrixPosition = getEntityTextureMatrixCoordinate(id-amountOfTerrainTypes);}

        Point textureMapPixelPosition = new Point(textureMapMatrixPosition.y * scale, textureMapMatrixPosition.x * scale);

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = bufferedImage.getGraphics();
        g.drawImage(textureImage, 0, 0, width, height, textureMapPixelPosition.x, textureMapPixelPosition.y,
                textureMapPixelPosition.x + scale, textureMapPixelPosition.y + scale, null);
        g.dispose();

        return new ImageIcon(bufferedImage);
    }


}
