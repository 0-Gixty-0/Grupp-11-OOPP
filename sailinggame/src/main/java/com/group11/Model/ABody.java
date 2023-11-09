package com.group11.Model;

import java.awt.*;
import java.util.ArrayList;

public abstract class ABody implements IDamageable {

    private ArrayList<Integer> dimension;
    private Point pos;
    private int hitPoints;
    private int velocity;

    public ABody(ArrayList<Integer> dimension, Point pos, int hitPoints, int velocity){
        this.dimension = dimension;
        this.pos = pos;
        this.hitPoints = hitPoints;
        this.velocity = velocity;
    }


    @Override
    public void takeDamage(int damage){
        this.hitPoints -= damage;
    }
}