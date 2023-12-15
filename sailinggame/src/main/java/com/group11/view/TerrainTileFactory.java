package com.group11.view;

import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class TerrainTileFactory extends AViewTileFactory {

    /**
     * Constructs a TerrainTileFactory.
     * The maximum texture ID is set to 1.
     */
    protected TerrainTileFactory() {
        super(1);
    }

    /**
     * Returns the coordinates of the terrain type in the texture map image.
     * The x-coordinate is the floor division of the terrain type ID by 4, and the y-coordinate is the terrain type ID modulo 4.
     *
     * @param id the terrain type ID
     * @return the coordinates of the terrain type in the texture map image
     */
    @Override
    protected Point getTextureMatrixCoordinate(int id) {
        return new Point((int) Math.floor(id/4), id % 4);
    }

    /**
     * Initializes the texture map image as an ImageIcon.
     * The image is loaded from the "textureMapSailingGame.png" file in the resources directory.
     *
     * @return the ImageIcon of the texture map image
     */
    @Override
    protected ImageIcon initTextureMapImageIcon() {
        return (new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/textureMapSailingGame.png"))));
    }
}