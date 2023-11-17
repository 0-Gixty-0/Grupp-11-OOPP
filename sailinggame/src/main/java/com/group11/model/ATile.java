package com.group11.model;

import java.awt.Point;
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
        super(textureId, pos);
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



