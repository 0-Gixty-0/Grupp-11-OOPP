package com.group11.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Abstract class representing an abstract body. Implements the IDamageable interface
 * since a body can take damage.
 */

public abstract class ABody extends APositonable implements IDamageable {

    private ArrayList<ArrayList<Boolean>> dimensions;
    private int hitPoints;
    String description;

    /**
     * Constructor for creating objects of type ABody, the physical part of an entity in the game.
     * @param dimension - the dimension of the body
     * @param pos       - the position of the body in the tilemap
     * @param hitPoints - the hitpoints of the body
     */
    protected ABody(ArrayList<ArrayList<Boolean>> dimensions, Point pos, int hitPoints, String description) {
        super(pos);
        this.dimensions = dimensions;
        this.hitPoints  = hitPoints;
    }

    /**
     * Reduces the hitpoints of the body
     * @param damage - the amount of damage taken by the body
     */
    @Override
    public void takeDamage(int damage){
        this.hitPoints -= damage;
    }

    /**
     * Returns the current hitpoints of the body
     * @return the current hitpoints of the body
     */
    public int getHitPoints() {
        return this.hitPoints;
    }

    /**
     * Sets the hitpoints of the body
     * @param newHitpoints - the new hitpoints value of the body
     */
    public void setHitPoints(int newHitpoints) {
        this.hitPoints = newHitpoints;
    }

    /**
     * 
     * @return dimensions of an object.
     */
    public ArrayList<ArrayList<Boolean>> getDimensions() {
        return dimensions;
    }
    
    /**
     * 
     * @param dimensions desired body dimensions.
     */
    public void setDimensions(ArrayList<ArrayList<Boolean>> dimensions) {
        this.dimensions = dimensions;
    }
}