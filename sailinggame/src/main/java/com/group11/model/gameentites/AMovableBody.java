package com.group11.model.gameentites;

import com.group11.model.utility.UMovementUtility;

import java.awt.Point;

/**
 * Abstract class representing an abstract movable body. This class extends ABody and implements the IMovable interface
 * since a movable body can take move.
 */

public abstract class AMovableBody extends ABody implements IMovable {

    /**
     * Constructor for a movable body, like a body but its meant to move around the game world.
     * @param pos       The starting position of the body as a Java Point
     * @param hitPoints The hitpoints of the body
     * @param description The description of the body   
     */
    protected AMovableBody(Point pos, double hitPoints){
        super(pos, hitPoints);
    }

    /**
     * Moves the body to a new position
     *
     * @param x - the new x position for the body
     * @param y - the new y position for the body
     */
    private void move(int x, int y) {
        this.getTruePos().setLocation(x, y);
    }

    /**
     * A Helper method for movement implementation using pseudo linear algebra. This should be the method
     * that does the actual moving of the body in subclasses.
     * @param dirVector The direction the body should move in.
     */
    public void moveIfPossible(int [] dirVector) {
        Point currPos = this.getPos();
        if (UMovementUtility.movementIsPossible(currPos, dirVector)) {
            int currX = (int) currPos.getX();
            int currY = (int) currPos.getY();
            this.move(currX + dirVector[0],currY + dirVector[1]);
        }
    }
}