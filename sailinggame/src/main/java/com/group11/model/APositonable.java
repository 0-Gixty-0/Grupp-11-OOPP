package com.group11.model;

import java.awt.Point;

/**
 * A class that is used as an abstraction that gives tiles and entities their position attribute
 */
public abstract class APositonable extends ATextureIdentifiable {

    /**
     * The position of a tile or entity as a Java Point.
     */
    private Point pos;

    protected APositonable(int textureId, Point pos){
        super(textureId);
        this.pos = pos;
    }

    public abstract void setPos();

    /**
    * Returns the position of a tile or entity
    * @return A Java Point for the position of the tile or entity
    */
    public Point getPos(){
        return this.pos;
    }
}
