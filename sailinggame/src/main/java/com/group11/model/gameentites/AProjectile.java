package com.group11.model.gameentites;

import java.awt.*;

/**
 * This abstract class represents an abstract projectile in the game. A projectile is a type of movable body
 * that can travel in a certain direction and cause damage.
 *
 * A projectile has a distance it has traveled, a maximum range it can travel, the damage it can cause,
 * the direction it is traveling in, and the hitpoints it has. A projectile always has 1 hitpoint.
 */
public abstract class AProjectile extends ABody{

    private int distanceTraveled;
    private int maxRange;
    private int damage;
    private int [] direction;
    private String projectileName;

    /**
     * Constructs a new projectile with the given parameters.
     * @param startingPos the starting position of the projectile
     * @param maxRange the maximum range the projectile can travel
     * @param damage the damage the projectile can cause
     * @param direction the direction the projectile is traveling in
     * @param projectileName the name of the projectile
     */

    protected AProjectile(Point startingPos, int maxRange, int damage, int [] direction, String projectileName){
        super(startingPos, 1);
        this.projectileName = projectileName;
        this.distanceTraveled = 0;
        this.maxRange = maxRange;
        this.damage = damage;
        this.direction = direction;
    }

    /**
     * Returns the name of the projectile.
     * @return the name of the projectile
     */
    protected String getProjectileName() {
        return this.projectileName;
    }

    /**
     * Checks if the projectile is out of range.
     * @return true if the projectile has traveled beyond its maximum range, false otherwise
     */
    protected boolean isOutOfRange() {
        return(this.distanceTraveled >= this.maxRange); 
    }

    /**
     * Makes the projectile travel in a predetermined path.
     */
    protected void moveInTravelPath() {
        if (!isOutOfRange()) {
            this.distanceTraveled++;
            continueTravelPath();
        }
    }

    /**
     * Returns the damage the projectile can cause.
     * @return the damage the projectile can cause
     */
    protected int getDamage() {
        return this.damage;
    }

    /**
     * Abstract method to move the projectile along its travel path.
     * This method must be implemented by subclasses.
     */
    protected abstract void continueTravelPath();

    protected int[] getDirection() {
        return this.direction;
    }
}