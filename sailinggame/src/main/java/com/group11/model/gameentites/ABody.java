package com.group11.model.gameentites;

import java.awt.Point;

/**
 * Abstract class representing an abstract body that is used by entities in the game.
 */
public abstract class ABody extends APositonable {
    private double hitPoints;

    /**
     * Constructor for creating objects of type ABody, the physical part of an entity in the game.
     *
     * @param pos       - the position of the body in the tilemap
     * @param hitPoints - the hitpoints of the body
     */
    protected ABody(Point pos, double hitPoints) {
        super(pos);
        this.hitPoints  = hitPoints;
    }

    /**
     * Reduces the hitpoints of the body
     *
     * @param damage - the amount of damage taken by the body
     */
    protected void takeDamage(int damage){
        this.hitPoints -= damage;
    }

    /**
     * Returns the current hitpoints of the body
     *
     * @return the current hitpoints of the body
     */
    protected double getHitPoints() {
        return this.hitPoints;
    }

    /**
     * Sets the hitpoints of the body
     *
     * @param newHitpoints - the new hitpoints value of the body
     */
    protected void setHitPoints(int newHitpoints) {
        this.hitPoints = newHitpoints;
    }
}