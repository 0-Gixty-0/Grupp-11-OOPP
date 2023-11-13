package com.group11.model;

/**
 * Class representing a ship. This class extends AMovableBody.
 */
public class Ship extends AMovableBody {

    private int shipLevel;
    private int armor;
    private int cannons;
    private boolean sailStatus;
    private boolean anchorDown = false;

    /**
     * Constructor for creating objects of type AShip.
     * @param shipLevel   - the level of the ship
     * @param armor       - the armor of the ship
     * @param cannons     - the cannons of the ship
     * @param sailStatus  - the sail status. Either up (true) or down (false)
     */
    public Ship(int shipLevel, int armor, int cannons, boolean sailStatus){
        super(0);
        this.shipLevel   = shipLevel;
        this.armor       = armor;
        this.cannons     = cannons;
        this.sailStatus  = sailStatus;
    }

    /**
     * Raises the sail of the ship
     */
    public void raiseSail() {
        sailStatus = true;
    }

    /**
     * Lower the sail of the ship
     */
    public void lowerSail() {
        sailStatus = false;
    }

    /**
     * Returns the sailStatus of the ship
     *
     * @return the sailStatus of the ship
     */
    public boolean getSailStatus() {
        return this.sailStatus;
    }

    /**
     * Fires the cannon of the ship
     *
     * @param damage - the amount of damage the cannon does
     */
    public void fireCannons(int damage){}

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
}