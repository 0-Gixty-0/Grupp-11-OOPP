package com.group11.view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import com.group11.view.uicomponents.ViewTile;



/**
 * The class is an abstract factory for creating ViewTile objects.
 */
public abstract class AViewTileFactory extends AImageUser {

    private static int tileWidth = 16; //Default values.
    private static int tileHeight = 16; 
    private int maxTextureId; //The maximum terrain type id.

    private List<ImageIcon> initializedIcons; //The list of ImageIcons for each terrain type.
    private ImageIcon emptyIcon; //The empty ImageIcon.

    protected AViewTileFactory(int maxTextureId) {
        super();
        this.maxTextureId = maxTextureId;
        this.initializedIcons = initIcons();
        this.emptyIcon = createImageIcon(-1, tileWidth, tileHeight);
    }

    /**
     * Set the tile dimensions to be used for creating the ViewTiles. Default at instantiation is 16x16.
     * @param tileWidth The width of the tiles.
     * @param tileHeight The height of the tiles.
     */
    public static void setTileDimensions(int tileWidth, int tileHeight) {
        AViewTileFactory.tileWidth = tileWidth;
        AViewTileFactory.tileHeight = tileHeight;
    }

    /**
     * The method creates a ViewTile object based on the terrain type id, dimension, matrix position, and pixel position.
     * @param id The texture id of the tile.
     * @return ViewTile object.
     */
    protected ViewTile createTile(Integer id) {
        validateTextureId(id);
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
     * The method creates a list of ImageIcons for each texture used in the factory.
     * @return ArrayList of ImageIcons.
     */
    private ArrayList<ImageIcon> initIcons() {
        ArrayList<ImageIcon> icons = new ArrayList<>();
        for (int i = 0; i < maxTextureId+1; i++) {
            icons.add(this.createImageIcon(i, tileWidth, tileHeight));
        }
        return icons;
    }

    /**
     * The method validates that the terrain type id is in a valid range.
     * @param id The terrain type id.
     */
    private void validateTextureId(int id) {
        if (id < -1 || id > maxTextureId) { 
            throw new IllegalArgumentException("Invalid terrain ID for entity tile");
        }
    }

    
}
