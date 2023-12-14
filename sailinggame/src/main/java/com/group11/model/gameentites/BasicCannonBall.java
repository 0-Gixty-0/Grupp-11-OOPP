package com.group11.model.gameentites;

import java.awt.Point;

import com.group11.model.utility.UMovement;

/**
 * This class represents a BasicCannonBall in the game. A BasicCannonBall is a type of projectile that can be fired by a weapon.
 *
 * A BasicCannonBall has a distance it has traveled, a maximum range it can travel, the damage it can cause,
 * the direction it is traveling in, and the hitpoints it has. A BasicCannonBall always has 1 hitpoint.
 */
public class BasicCannonBall extends AProjectile {

    /**
     * Constructs a new BasicCannonBall with the given parameters.
     * @param pos the position of the BasicCannonBall
     * @param direction the direction of the BasicCannonBall
     */
    public BasicCannonBall(Point pos, int [] direction) {
        super(pos, 20, 10, direction, "CannonBall");
    }

    /**
     * Moves the BasicCannonBall along its travel path if possible.
     * The direction of the movement is determined by the current direction of the BasicCannonBall.
     */
    @Override
    protected void continueTravelPath() {
        if (UMovement.movementIsPossible(getPos(), getDirection())) {
            Point pos = this.getTruePos();
            pos.setLocation(pos.getX() + getDirection()[0] , pos.getY() + getDirection()[1]);
        }
    }
}