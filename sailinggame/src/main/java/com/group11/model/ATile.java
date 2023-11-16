package com.group11.model;

import java.awt.Point;

public abstract class ATile extends ATextureIdentifiable{
    
    private Point pos;
    private Boolean passable;

    protected ATile(int textureId, Point pos, Boolean passable ) {
        super(textureId);
    }
    
    public Point getPos(){
        return this.pos;
    }

    public Boolean isPassable(){
        return this.passable;
    }

}



