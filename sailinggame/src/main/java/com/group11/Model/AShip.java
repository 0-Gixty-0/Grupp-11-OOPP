package com.group11.model;

/**
 * Abstract class representing an abstract ship. This class extends AMovableBody.
 */
public abstract class AShip extends AMovableBody {

    private int sailLevel;
    private int armor;
    private int cannons;
    private boolean sailStatus;
    private boolean anchorDown = false;

    /**
     * Constructor for creating objects of type AShip.
     * @param sailLevel   - the level of the sail of the ship
     * @param armor       - the armor of the ship
     * @param cannons     - the cannons of the ship
     * @param sailStatus  - the sail status. Either up (true) or down (false)
     */
    public AShip(int sailLevel, int armor, int cannons, boolean sailStatus){
        super(0);
        this.sailLevel = sailLevel;
        this.armor = armor;
        this.cannons = cannons;
        this.sailStatus = sailStatus;
        setVelocity(getVelocity());
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
    abstract public void fireCannons(int damage);

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