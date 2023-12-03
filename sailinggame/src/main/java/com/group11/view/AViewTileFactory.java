package com.group11.view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import com.group11.view.uicomponents.ViewTile;


/**
 * The class is an abstract factory for creating ViewTile objects.
 */
public abstract class AViewTileFactory extends AViewDrawableFactory {

    private static int tileWidth = 16;
    private static int tileHeight = 16;
    private int maxTextureId;
    private List<ImageIcon> initializedIcons;
    private ImageIcon emptyIcon;

    protected AViewTileFactory(int maxTextureId) {
        super();
        this.maxTextureId = maxTextureId;
        this.initializedIcons = initIcons();
        this.emptyIcon = createImageIcon(-1, tileWidth, tileHeight);
    }

    /**
     * Set the tile dimensions to be used for creating the ViewTiles.
     * @param tileWidth The width of the tiles.
     * @param tileHeight The height of the tiles.
     */
    public static void setTileDimensions(int tileWidth, int tileHeight) {
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
     * @return ViewTile object
     */
    protected ViewTile createdDrawable(Integer id) {
        Dimension dimension = new Dimension(tileWidth, tileHeight);
        ImageIcon imageIcon;
        if (id == -1) {
            imageIcon = this.emptyIcon;
        } else {
            imageIcon = this.initializedIcons.get(id);
        }
        ViewTile viewTile = new ViewTile(imageIcon, dimension);
        viewTile.setName(id.toString());
        return viewTile;
    }

    /**
     * The method creates a ViewTile object based on the terrain type id, dimension, matrix position, and pixel position.
     * @param id The texture id of the tile.
     * @param dimension The dimension of the tile.
     * @return ViewTile object
     */
    protected ArrayList<ImageIcon> initIcons() {
        ArrayList<ImageIcon> icons = new ArrayList<>();
        for (int i = 0; i < maxTextureId+1; i++) {
            icons.add(this.createImageIcon(i, getTileWidth(), getTileHeight()));
        }
        return icons;
    }

    @Override
    protected void validateTextureId(int id) {
        if (id < -1 || id > maxTextureId) { 
            throw new IllegalArgumentException("Invalid terrain ID for entity tile");
        }
    }
}
