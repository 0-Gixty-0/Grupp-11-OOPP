package com.group11.model;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Abstract class representing an abstract movable body. This class extends ABody and implements the IMovable interface
 * since a movable body can take move.
 */

public abstract class AMovableBody extends ABody implements IMovable {

    private int velocity;

    /**
     * Constructor for a movable body, like a body but its meant to move around the game world.
     * @param dimensions The dimensions of the body represented as a matrix of true (uses that square) or false (does not use that square)
     * @param pos The starting position of the body as a Java Point
     * @param hitPoints The hitpooints of the body
     */
    protected AMovableBody(ArrayList<ArrayList<Boolean>> dimensions, Point pos, int hitPoints, int textureId, String description){
        super(dimensions, pos, hitPoints, textureId, description);
        this.velocity = 0;
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
        this.getTruePos().setLocation(x, y);
    }
}