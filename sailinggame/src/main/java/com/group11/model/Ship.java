package com.group11.model;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Class representing a ship. This class extends AMovableBody.
 */
public class Ship extends AMovableBody implements HasWeapon {

    private int shipLevel;
    private int armor;
    private int cannons;
    private boolean sailIsUp;
    private boolean anchorDown;

    /**
     * Constructor for creating objects of type AShip.
     * @param shipLevel   - the level of the ship
     * @param armor       - the armor of the ship
     * @param cannons     - the cannons of the ship
     * @param sailStatus  - the sail status. Either up (true) or down (false)
     */
    public Ship(ArrayList<ArrayList<Boolean>> dimensions, Point pos, int shipLevel, int armor, int cannons, int hitPoints){
        super(dimensions, pos, hitPoints, "A basic ship");
        this.shipLevel   = shipLevel;
        this.armor       = armor;
        this.cannons     = cannons;
        this.sailIsUp  = false;
        this.anchorDown = true;
    }

    /**
     * Raises the sail of the ship
     */
    public void raiseSail() {
        if (!this.sailIsUp) {
            sailIsUp = true;
            int currVelocity = this.getVelocity();
            this.setVelocity(currVelocity*2);
        } 
    }

    /**
     * Lower the sail of the ship
     */
    public void lowerSail() {
        if (this.sailIsUp) {
            sailIsUp = false;
            int currVelocity = this.getVelocity();
            this.setVelocity(currVelocity/2);
        } 
    }

    /**
     * Returns the sailStatus of the ship
     *
     * @return the sailStatus of the ship
     */
    public boolean getSailStatus() {
        return this.sailIsUp;
    }

    /**
     * Fires the cannon of the ship
     *
     * @param damage - the amount of damage the cannon does
     */
    public void fireCannons(int direction){
        //Not implemented in the current state of the game, view this as a placeholder
    }

    /**
     * Returns the anchorStatus of the ship. Down (true) up (false)
     *
     * @return the anchorStatus of the ship.
     */
    public boolean getAnchorStatus() {
        return this.anchorDown;
    }

    /**
     * Raises the anchor of the ship.
     */
    public void anchorUp() {
        this.anchorDown = false;
    }

    /**
     * Lowers the anchor of the ship, reducing its velocity to 0.
     */
    public void anchorDown() {
        this.anchorDown = true;
        setVelocity(0);
    }

    /**
     * This method fires the weapon of the ship in a certain direction
     * @param direction Direction to fire the weapon in
     */
    @Override
    public void fireWeapon(int[] direction) {
        // Not yet implemented
    }
}