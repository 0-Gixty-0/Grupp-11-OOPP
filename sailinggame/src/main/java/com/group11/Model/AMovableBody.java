package com.group11.Model;

import java.awt.*;
import java.util.ArrayList;

public abstract class AMovableBody extends ABody implements IMovable{

    private int velocity;

    public AMovableBody(int velocity){
        super(new ArrayList<>(), (new Point()), 100, velocity);
        this.velocity = velocity;
    }

    public int getVelocity() {
        return this.velocity;
    }

    public void setVelocity(int new_velocity){
        this.velocity = new_velocity;
    }

    @Override
    public void move(int x, int y){
    }
}