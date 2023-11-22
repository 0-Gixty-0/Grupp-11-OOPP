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
     * Constructor for creating objects of type Ship. Allows for precise control of creation
     * @param dimensions
     * @param pos Position of the ship
     * @param shipLevel   - the level of the ship
     * @param armor       - the armor of the ship
     * @param cannons     - the cannons of the ship
     */

    public Ship(ArrayList<ArrayList<Boolean>> dimensions, Point pos, int shipLevel, int armor, int cannons, int hitPoints){
        super(dimensions, pos, hitPoints, "Custom Ship");
        this.shipLevel   = shipLevel;
        this.armor       = armor;
        this.cannons     = cannons;
        this.sailIsUp  = false;
        this.anchorDown = true;
    }

    public Ship(ArrayList<ArrayList<Boolean>> dimensions, Point pos) {
        super(dimensions, pos, 20, "Standard Ship, Custom: Dimensions, Position");
        this.shipLevel = 1;
        this.armor = 2;
        this.cannons = 5;
        this.sailIsUp = true;
        this.anchorDown = false;
    }

    public Ship(Point pos) {
        super(Ship.createStandardDimensions(), pos, 20, "Standard Ship Custom: Position");
        createStandardDimensions();
    }

    private static ArrayList<ArrayList<Boolean>> createStandardDimensions() {
        ArrayList<ArrayList<Boolean>> dimensions = new ArrayList<>();
        ArrayList<Boolean> row = new ArrayList<>();
        row.add(true);
        dimensions.add(row);
        return dimensions;
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