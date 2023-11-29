package com.group11.model.game_entites;

import java.awt.Point;

/**
 * Abstract class representing an abstract body. Implements the IDamageable interface
 * since a body can take damage.
 */

public abstract class ABody extends APositonable implements IDamageable {
    private double hitPoints;
    String description;

    /**
     * Constructor for creating objects of type ABody, the physical part of an entity in the game.
     *
     * @param pos       - the position of the body in the tilemap
     * @param hitPoints - the hitpoints of the body
     */
    protected ABody(Point pos, double hitPoints, String description) {
        super(pos);
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
    public double getHitPoints() {
        return this.hitPoints;
    }

    /**
     * Sets the hitpoints of the body
     * @param newHitpoints - the new hitpoints value of the body
     */
    public void setHitPoints(int newHitpoints) {
        this.hitPoints = newHitpoints;
    }
}