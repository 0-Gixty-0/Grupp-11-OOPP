package com.group11.Model;

import java.awt.Point;

public abstract class ATile extends ADrawable{
    private Point pos;
    private Boolean passable;

    public Point getPos(){
        return this.pos;
    }

    public Boolean isPassable(){
        return this.passable;
    }
}



