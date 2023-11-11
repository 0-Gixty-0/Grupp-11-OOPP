package com.group11.Model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Abstract class representing an abstract movable body. This class extends ABody and implements the IMovable interface
 * since a movable body can take move.
 */

public abstract class AMovableBody extends ABody implements IMovable {


    /**
     * Constructor for creating objects of type AMovableBody.
     *
     * @param velocity - the initial velocity of the body
     */
    public AMovableBody(int velocity){
        super(new ArrayList<>(), (new Point()), 100, velocity);
    }

    /**
     * Moves the body to a new position
     *
     * @param x - the new x position for the body
     * @param y - the new y position for the body
     */
    public void move(int x, int y) {
        this.setPos(new Point(x,y));
    }
}