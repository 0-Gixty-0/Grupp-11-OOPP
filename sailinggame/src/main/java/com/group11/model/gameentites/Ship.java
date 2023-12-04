package com.group11.model.gameentites;

import java.awt.Point;

/**
 * Class representing a ship. This class extends AMovableBody.
 */
public class Ship extends AMovableBody implements IHasWeapon {

    private int shipLevel;
    private double armor;
    private int cannons;

    /**
     * Constructor for creating objects of type Ship.
     * @param pos coordinate position of the ship
     * @param shipLevel  - the level of the ship
     * @param armor      - the armor of the ship
     * @param cannons    - the cannons of the ship
     * @param hitPoints the number of hitpoints of the ship
     */
    public Ship(Point pos, int shipLevel, double armor, int cannons, double hitPoints){
        super(pos, hitPoints, "A basic ship");
        this.shipLevel   = shipLevel;
        this.armor       = armor;
        this.cannons     = cannons;
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
    }

    /**
     * Returns ship level
     * @return ship level
     */
    public int getShipLevel() {
        return this.shipLevel;
    }

    /**
     * Returns armor rating
     * @return armor rating
     */
    public double getArmor() {
        return this.armor;
    }

    /**
     * Returns cannon rating
     * @return cannon rating
     */
    public int getCannons() {
        return this.cannons;
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