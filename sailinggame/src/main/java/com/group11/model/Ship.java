package com.group11.model;

import java.awt.Point;

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
     * Constructor for creating objects of type Ship.
     * @param pos coordinate position of the ship
     * @param shipLevel  - the level of the ship
     * @param armor      - the armor of the ship
     * @param cannons    - the cannons of the ship
     * @param hitPoints the number of hitpoints of the ship
     */
    public Ship(Point pos, int shipLevel, int armor, int cannons, int hitPoints){
        super(pos, hitPoints, "A basic ship");
        this.shipLevel   = shipLevel;
        this.armor       = armor;
        this.cannons     = cannons;
        this.sailIsUp  = false;
        this.anchorDown = true;
    }

    /**
     * Constructor for creating default objects of type Ship with custom position
     * @param pos coordinate position of the ship
     */
    public Ship(Point pos) {
        super(pos, 20, "Standard Ship, Custom: Position");
        this.shipLevel = 1;
        this.armor = 2;
        this.cannons = 5;
        this.sailIsUp = true;
        this.anchorDown = false;
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