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

    public int getHitPoints() {
        return this.hitPoints;
    }

    public void setHitPoints(int new_hitpoints) {
        this.hitPoints = new_hitpoints;
    }

    public void setVelocity(int new_velocity) {
        this.velocity = new_velocity;
    }

    public int getVelocity() {
        return this.velocity;
    }

    public Point getPos(){
        return this.pos;
    }

    public void setPos(Point new_position){
        this.pos = new_position;
    }
}