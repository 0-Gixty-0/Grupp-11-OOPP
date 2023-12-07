package com.group11.model.gameentites;

import java.awt.Point;

/**
 * Class representing a ship. This class extends AMovableBody.
 */
public class Ship extends AMovableBody implements IHasWeapon {

    private int shipLevel;
    private double armor;
    private AWeapon weapon;

    /**
     * Constructor for creating objects of type Ship.
     * @param pos coordinate position of the ship
     * @param shipLevel  - the level of the ship
     * @param armor      - the armor of the ship
     * @param weapon    - the weapon of the ship
     * @param hitPoints the number of hitpoints of the ship
     */
    public Ship(Point pos, int shipLevel, double armor, AWeapon weapon, double hitPoints){
        super(pos, hitPoints, "A basic ship");
        this.shipLevel   = shipLevel;
        this.armor       = armor;
        this.weapon = weapon;
    }

    /**
     * Constructor for creating default objects of type Ship with custom position
     * @param pos coordinate position of the ship
     */
    public Ship(Point pos) {
        super(pos, 100, "Standard Ship, Custom: Position");
        this.shipLevel = 1;
        this.armor = 2;
        this.weapon = new BasicCannon(BasicCannonBall.class);
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
     * Returns weapon
     * @return active weapon
     */
    public AWeapon getWeapon() {
        return this.weapon;
    }

    /**
     * This method fires the weapon of the ship in a certain direction
     * @param direction Direction to fire the weapon in
     */
    @Override
    public void fireWeapon(int[] direction) {
        Point firingPoint = new Point(this.getPos().x + direction[0], this.getPos().y + direction[1]);
        this.weapon.fireWeapon(firingPoint, direction);
    }
}