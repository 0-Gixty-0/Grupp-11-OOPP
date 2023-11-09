package com.group11.Model;

public class SmallShip extends AShip {

    public SmallShip(int sailArea, int armor, int cannons, ArrayList<Item> inventory) {
        super(sailArea, armor, cannons, inventory);
    }

    @Override
    public void move(int x, int y) {
    }

    @Override
    public void fireCannons(int) {
    }
}