package com.group11.view;

import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

/**
 * The class is a factory for creating ViewTile objects representing entities.
 * It extends the AViewTileFactory abstract class and overrides its methods to provide specific implementation for entities.
 */
public class EntityTileFactory extends AViewTileFactory {

    /**
     * Constructs an EntityTileFactory.
     * The maximum texture ID is set to 7.
     */
    protected EntityTileFactory() {
        super(7);
    }

    /**
     * Returns the coordinates of the entity type in the texture map image.
     * The x-coordinate is always 0, and the y-coordinate is the entity type ID modulo 8.
     *
     * @param id the entity type ID
     * @return the coordinates of the entity type in the texture map image
     */
    @Override
    protected Point getTextureMatrixCoordinate(int id) {
        return new Point(0, id % 8);
    }

    /**
     * Initializes the texture map image as an ImageIcon.
     * The image is loaded from the "entityTextureMap.png" file in the resources directory.
     *
     * @return the ImageIcon of the texture map image
     */
    @Override
    protected ImageIcon initTextureMapImageIcon() {
        return (new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/entityTextureMap.png"))));
    }
}