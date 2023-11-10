package com.group11.Model;

import java.awt.*;

public class SmallShip extends AShip {

    public SmallShip(int sailLevel, int armor, int cannons, boolean sailStatus) {
        super(sailLevel, armor, cannons, sailStatus);
    }

    @Override
    public void move(int x, int y) {
        Point new_position = new Point (x, y);
        this.setPos(new_position);
    }

    @Override
    public void fireCannons(int damage) {
    }
}