package com.group11.view;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.ImageIcon;


/**
 * The class is an abstract factory for creating ViewTile objects.
 */
public abstract class AViewTileFactory extends AViewDrawableFactory {

    private static int tileWidth = 16;
    private static int tileHeight = 16;
    
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
     * The method creates a ViewTile object based on the terrain type id, dimension, matrix position, and pixel position.
     * @param id The texture id of the tile.
     * @param dimension The dimension of the tile
     * @param matrixPosition The matrix position of the tile
     * @return ViewTile object
     */
    protected ViewTile createDrawable(Integer id) {
        this.validateTextureId(id);
        Dimension dimension = new Dimension(tileWidth, tileHeight);
        ImageIcon imageIcon = createImageIcon(id, dimension.width, dimension.height);
        ViewTile viewTile = new ViewTile(imageIcon, dimension);
        viewTile.setName(id.toString());
        return viewTile;
    }

}
