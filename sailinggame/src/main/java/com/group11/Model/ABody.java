package com.group11.Model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Abstract class representing an abstract body. Implements the IDamageable interface
 * since a body can take damage.
 */

public abstract class ABody implements IDamageable {

    private ArrayList<Integer> dimension;
    private Point pos;
    private int hitPoints;
    private int velocity;

    /**
     * Constructor for creating objects of type ABody.
     * @param dimension - the dimension of the body
     * @param pos       - the position of the body in the tilemap
     * @param hitPoints - the hitpoints of the body
     * @param velocity  - the velocity of the body
     */
    public ABody(ArrayList<Integer> dimension, Point pos, int hitPoints, int velocity){
        this.dimension = dimension;
        this.pos = pos;
        this.hitPoints = hitPoints;
        this.velocity = velocity;
    }

    /**
     * Reduces the hitpoints of the body
     *
     * @param damage - the amount of damage taken by the body
     */
    @Override
    public void takeDamage(int damage){
        this.hitPoints -= damage;
    }

    /**
     * Returns the current hitpoints of the body
     *
     * @return the current hitpoints of the body
     */
    public int getHitPoints() {
        return this.hitPoints;
    }

    /**
     * Sets the hitpoints of the body
     *
     * @param newHitpoints - the new hitpoints value of the body
     */
    public void setHitPoints(int newHitpoints) {
        this.hitPoints = newHitpoints;
    }

    /**
     * Returns the current velocity of the body
     *
     * @return the current velocity of the body
     */
    public int getVelocity() {
        return this.velocity;
    }

    /**
     * Sets the velocity of the body
     *
     * @param newVelocity - the new velocity of the body
     */
    public void setVelocity(int newVelocity) {
        this.velocity = newVelocity;
    }

    /**
     * Returns the current position of the body
     *
     * @return the current position of the body
     */
    public Point getPos(){
        return this.pos;
    }

    /**
     * Sets the position of the body
     *
     * @param newPosition - the new position of the body
     */
    public void setPos(Point newPosition){
        this.pos = newPosition;
    }
}