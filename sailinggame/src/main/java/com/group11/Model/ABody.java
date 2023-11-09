package com.group11.Model;

import java.util.ArrayList;

public abstract class ABody implements IDamageable {

    private Array<int> dimension;
    private Point pos;
    private int hitPoints;
    private int velocity;

    public ABody(Array<int> dimension, Position pos, int hitPoints, int velocity){
        this.dimension = dimension;
        this.pos = pos;
        this.hitPoints = hitpoints;
        this.velocity = velocity;
    }


    @Override
    public void takeDamage(int damage){
        this.hitPoints -= damage;
    }
}