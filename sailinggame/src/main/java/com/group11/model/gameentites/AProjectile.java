package com.group11.model.gameentites;

import java.awt.*;

/**
 * This abstract class represents an abstract projectile in the game. A projectile is a type of movable body
 * that can travel in a certain direction and cause damage.
 *
 * A projectile has a distance it has traveled, a maximum range it can travel, the damage it can cause,
 * the direction it is traveling in, and the hitpoints it has. A projectile has always 1 hitpoint.
 */

public abstract class AProjectile extends AMovableBody{

    private int distanceTraveled;
    private int maxRange;
    private int damage;
    private int [] direction;

    /**
     * Constructs a new projectile with the given parameters.
     * @param pos the position of the projectile
     * @param maxRange the maximum range the projectile can travel
     * @param damage the damage the projectile can cause
     * @param direction the direction the projectile is traveling in
     */

    protected AProjectile(Point startingPos, int maxRange, int damage, int [] direction){
        super(startingPos, 1, "Projectile");
        this.distanceTraveled = 0;
        this.maxRange = maxRange;
        this.damage = damage;
        this.direction = direction;
    }

    /**
     * Checks if the projectile is out of range.
     * @return true if the projectile has traveled beyond its maximum range, false otherwise
     */
    public boolean isOutOfRange() {
        return(this.distanceTraveled >= this.maxRange); 
    }

    /**
     * Makes the projectile travel in a predetermined path.
     */
    public void moveInTravelPath() {
        if (!isOutOfRange()) {
            this.distanceTraveled++;
            continueTravelPath();
        }
    }

    /**
     * Returns the damage the projectile can cause.
     * @return the damage the projectile can cause
     */
    public int getDamage() {
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