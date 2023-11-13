package com.group11.model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Abstract class representing an abstract movable body. This class extends ABody and implements the IMovable interface
 * since a movable body can take move.
 */

public abstract class AMovableBody extends ABody implements IMovable {

    private int velocity;

    /**
     * Constructor for creating objects of type AMovableBody.
     *
     * @param velocity - the initial velocity of the body
     */
    public AMovableBody(int velocity){
        super(new ArrayList<>(), (new Point()), 0);
        this.velocity = velocity;
    }

    /**
     * Returns the current velocity of the body
     *
     * @return the current velocity of the body
     */
    public int getVelocity() {
        return this.velocity;
    }

    /**
     * Sets the velocity of the body
     *
     * @param newVelocity - the new velocity of the body
     */
    public void setVelocity(int newVelocity) {
        this.velocity = newVelocity;
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