package com.group11.model.gameworld;

import java.awt.Point;

import com.group11.model.gameentites.APositonable;
/**
 * This class is used as an abstraction for the tile object
 */
public abstract class ATile extends APositonable{

    /**
     * Boolean that checks if the tile is passable.
     */
    private Boolean passable;

    /**
    * Constructor for the abstract class ATile
    * @param textureId - The texture ID for this specific tile
    * @param pos - The position of a tile as a Java Point 
    * @param passable - Boolean that checks if the tile is passable
    */
    protected ATile(int textureId, Point pos, Boolean passable ) {
        super(pos);
        this.passable = passable;
    }

    /**
    * Returns if the tile is passable or not
    * @return A boolean that says if the current point is passable or not
    */
    public Boolean isPassable(){
        return this.passable;
    }

}



