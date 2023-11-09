package com.group11.Model;

import javax.swing.text.Position;

public abstract class ATile extends ADrawable{
    private Position pos;
    private Boolean passable;

    public Position getPos(){
        return this.pos;
    }

    public Boolean isPassable(){
        return this.passable;
    }
}

