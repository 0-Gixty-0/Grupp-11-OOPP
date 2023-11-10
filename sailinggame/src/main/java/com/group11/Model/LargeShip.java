package com.group11.Model;

import java.awt.*;

public class LargeShip extends AShip {

    public LargeShip(int sailArea, int armor, int cannons) {
        super(sailArea, armor, cannons);
    }

    @Override
    public void move(int x, int y) {
        Point new_position = new Point (x, y);
        this.setPos(new_position);
    }

    @Override
    public void fireCannons(int number) {
    }
}