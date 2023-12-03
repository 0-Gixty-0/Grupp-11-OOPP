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
     *
     * @param distanceTraveled the distance the projectile has already traveled
     * @param maxRange the maximum distance the projectile can travel
     * @param damage the damage the projectile can cause
     * @param direction the direction the projectile is traveling in
     * @param hitPoints the hitpoints of the projectile, which is always 1
     */

    protected AProjectile(int maxRange, int damage, int [] direction){
        super(new Point(0,0), 1, "A projectile");
        this.distanceTraveled = 0;
        this.maxRange = maxRange;
        this.damage = damage;
        this.direction = direction;
        this.hitPoints = 1;
    }

    /**
     * Checks if the projectile is out of range.
     *
     * @return true if the projectile has traveled beyond its maximum range, false otherwise
     */
    public boolean isOutOfRange() {
        return(this.distanceTraveled > this.maxRange); 
    }

    /**
     * Returns the distance the projectile has traveled.
     *
     * @return the distance the projectile has traveled
     */
    public int getDistanceTraveled() {
        return this.distanceTraveled;
    }

    /**
     * Makes the projectile travel, increasing its traveled distance by one.
     */
    public void travel() {

        this.distanceTraveled++;

        continueTravelPath();
    }

    /**
     * Returns the direction the projectile is traveling in.
     *
     * @return the direction the projectile is traveling in
     */
    public int[] getDirection() {
        return this.direction;
    }

    /**
     * Sets the direction the projectile is traveling in.
     *
     * @param direction the new direction for the projectile
     */
    public void setDirection(int[] direction) {
        this.direction = direction;
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
    public void continueTravelPath() {
        moveInTravelPath(); //Checking for out of bounds is done in moveInTravelPath
    }
}