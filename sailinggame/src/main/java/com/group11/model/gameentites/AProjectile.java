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

    protected int distanceTraveled;
    protected int maxRange;
    protected int damage;
    protected int [] direction;
    protected int hitPoints;

    /**
     * Constructs a new projectile with the given parameters.
     * @param pos the position of the projectile
     * @param maxRange the maximum range the projectile can travel
     * @param damage the damage the projectile can cause
     * @param direction the direction the projectile is traveling in
     */

    protected AProjectile(Point pos, int maxRange, int damage, int [] direction){
        super(pos, 1, "Projectile");
        this.distanceTraveled = 0;
        this.maxRange = maxRange;
        this.damage = damage;
        this.direction = direction;
        this.hitPoints = 1;
    }

    /**
     * Checks if the projectile is out of range.
     * @return true if the projectile has traveled beyond its maximum range, false otherwise
     */
    public boolean isOutOfRange() {
        return(this.distanceTraveled >= this.maxRange); 
    }

    /**
     * Makes the projectile travel, increasing its traveled distance by one.
     */
    public void travel() {
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
    protected abstract void moveInTravelPath();

    /**
     * Continues the projectile along its travel path.
     * If an exception occurs during the movement, the method simply returns.
     */
    private void continueTravelPath() {
        moveInTravelPath(); //Checking for out of bounds is done in moveInTravelPath
    }
}