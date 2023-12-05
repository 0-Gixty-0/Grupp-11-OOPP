package com.group11.model.gameentites;

import java.awt.Point;

/**
 * This class represents a BasicCannonBall in the game. A BasicCannonBall is a type of projectile that can be fired by a weapon.
 *
 * A BasicCannonBall has a distance it has traveled, a maximum range it can travel, the damage it can cause,
 * the direction it is traveling in, and the hitpoints it has. A BasicCannonBall always has 1 hitpoint.
 */
public class BasicCannonBall extends AProjectile {

    /**
     * Constructs a new BasicCannonBall with the given parameters.
     * The distance traveled is initialized to 0, the maximum range is 30, the damage is 10, the direction is {0, 0}, and the hitpoints is 1.
     */
    public BasicCannonBall(Point pos, int [] direction) {
        super(pos, 30, 10, direction);
    }

    /**
     * Moves the BasicCannonBall along its travel path if possible.
     * The direction of the movement is determined by the current direction of the BasicCannonBall.
     */
    @Override
    public void moveInTravelPath() {
        this.moveIfPossible(this.direction);
    }
}